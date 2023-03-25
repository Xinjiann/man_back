package io.renren.modules.shipping.controller.man;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.common.entity.UserPO;
import io.renren.modules.common.service.WxUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 物流用户
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@RestController
@RequestMapping("shipping_man/user")
public class ShippingUserController {
    @Autowired
    private WxUserService wxUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wxUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		UserPO user = wxUserService.getById(id);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserPO user){
		wxUserService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserPO user){
		wxUserService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		wxUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
