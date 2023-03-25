package io.renren.modules.common.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtilsForLogin {

    public static final String ACCESS_TOKEN = "TOKEN_GIFT_";//客户端请求服务器时携带的token参数
    public static final String REFRESH_TOKEN = "REFRESH_GIFT_";//客户端用户刷新token的参数
    public static final String PHONE_VALID_CODE = "PHONE_VALID_CODE_";//客户端短信验证码


    private RedisUtilsForLogin(){}


    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * @Description: 设置缓存，k-v形式
     * @param key
     * @param value
     * @param timeout：单位：毫秒
     */
    public void setValue(String key, String value, long timeout ){
        redisTemplate.opsForValue().set(key, value, timeout , TimeUnit.MILLISECONDS);
    }

    /**
     * @Description: 设置access_token的缓存
     * @param userId
     * @param value
     * @param timeout
     */
    public void setToken(Integer userId, String value, long timeout){
        setValue(ACCESS_TOKEN + userId, value, timeout);
    }
    /**
     * @Description: 设置refresh_token缓存，缓存时间固定为7天
     * @param userId
     * @param value
     */
    public void setRefreshToken(Integer userId, String value){
        setValue(REFRESH_TOKEN + userId, value, 1296000000L);
    }
    /**
     * @Description: 获取缓存，通过key获取value值
     * @param key
     * @return
     */
    public String getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * @Description: 获取redis中的access_token信息
     * @param userId
     * @return
     */
    public String getToken(Integer userId){
        return getValue(ACCESS_TOKEN + userId);
    }
    /**
     * @Description: 获取redis中的refresh_token信息
     * @param userId
     * @return
     */
    public String getRefreshToken(Integer userId){
        return getValue(REFRESH_TOKEN + userId);
    }
    /**
     * @Description: 删除缓存
     * @param key
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }
}
