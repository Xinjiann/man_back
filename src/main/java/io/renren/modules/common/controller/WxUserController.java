package io.renren.modules.common.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.jsonwebtoken.Claims;
import io.renren.common.exception.code.ResultStatusCode;
import io.renren.common.utils.AudienceProperties;
import io.renren.common.utils.Result;
import io.renren.modules.common.entity.UserPO;
import io.renren.modules.common.entity.param.WxLoginParam;
import io.renren.modules.common.service.WxUserService;
import io.renren.modules.common.utils.RedisUtilsForLogin;
import io.renren.modules.common.weixin.common.OpenApi;
import io.renren.modules.common.weixin.utils.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 物流用户 前端控制器
 * </p>
 *
 * @author lixinjian
 * @since 2023-03-15
 */
@RestController
@Slf4j
@RequestMapping("/client/wx-user")
public class WxUserController {

    @Resource
    private WxUserService wxUserService;

    @Resource
    private RedisUtilsForLogin redisUtilsForLogin;

    @Resource
    private AudienceProperties audienceProperties;

    /**
     * 登陆/注册
     * @param loginParam
     * @return
     * @throws IOException
     */
    @PostMapping(value = "login")
    public Result login(@RequestBody WxLoginParam loginParam) throws IOException {
        String data = OpenApi.getWeixinData(loginParam.getJsCode());
        JSONObject jsonObj = JSONObject.parseObject(data);
        UserPO user = new UserPO();
        if (jsonObj.containsKey("session_key")) {
            log.info("================调微信成功=====================");
            String openId = jsonObj.get("openid").toString();
            QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("openId", openId);
            queryWrapper.eq("deleted", 0);
            UserPO userInfo = wxUserService.getOne(queryWrapper);
            if (userInfo == null) {
                user.setOpenid(openId);
                user.setUserName(loginParam.getName());
                user.setPhone(loginParam.getPhone());
                user.setAvatar(loginParam.getAvatar());
                user.setCreateTime(new Date());
                user.setDeleted(0);
                wxUserService.save(user);
            } else {
                user = userInfo;
            }
        } else {
            return Result.fail(ResultStatusCode.SYSTEM_ERR.getMsg());
        }
        //一个用户同时只能有一台设备登录（用户端）
        String redisToken = redisUtilsForLogin.getToken(user.getId());
        if (StringUtils.isNotEmpty(redisToken)) {
            String HeadStr = redisToken.substring(0, 6).toLowerCase();
            if (HeadStr.equals("bearer")) {
                redisToken = redisToken.substring(6);
                Claims claims = JwtHelper.parseJWT(redisToken, audienceProperties.getBase64Secret());
                //判断密钥是否相等，如果不等则认为时无效的token
                if (claims != null) {
                    return Result.fail(ResultStatusCode.LOGINED_IN.getMsg());
                }
            }
        }
        return Result.success(redisLoginInfo(user));
    }

    private Map<String, Object> redisLoginInfo(UserPO user) {
        //设置单次的token的过期时间为凌晨3点-4点，用于避免token在即将失效时继续使用旧的token访问
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, +1);
        cal.set(Calendar.HOUR_OF_DAY, 3);
        //拼装accessToken
        String accessToken = JwtHelper.createJWT(user.getUserName(), user.getId(),
                audienceProperties.getClientId(), audienceProperties.getName(),
                cal.getTimeInMillis() - System.currentTimeMillis(), audienceProperties.getBase64Secret());
        //将该用户的access_token储存到redis服务器，保证一段时间内只能有一个有效的access_token
        redisUtilsForLogin.setToken(user.getId(), accessToken, cal.getTimeInMillis() - System.currentTimeMillis());
        //获取refresh_token，有效期为7天，每次通过refresh_token获取access_token时，会刷新refresh_token的时间
        String refreshToken = JwtHelper.createRefreshToken(user.getUserName(), user.getId(), audienceProperties.getClientId(), audienceProperties.getName(), audienceProperties.getBase64Secret());
        redisUtilsForLogin.setRefreshToken(user.getId(), refreshToken);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("access_token", "bearer" + accessToken);
        result.put("refresh_token", "bearer" + refreshToken);
        result.put("user", user);
        return result;
    }

}
