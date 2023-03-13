package io.renren.modules.shipping.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.shipping.entity.WishesEntity;
import io.renren.modules.shipping.service.WishesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 留言板
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@RestController
@RequestMapping("shipping/wishes")
public class WishesController {
    @Autowired
    private WishesService wishesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wishesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		WishesEntity wishes = wishesService.getById(id);

        return R.ok().put("wishes", wishes);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WishesEntity wishes){
		wishesService.save(wishes);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WishesEntity wishes){
		wishesService.updateById(wishes);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		wishesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
