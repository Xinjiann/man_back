package io.renren.modules.companion.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.companion.entity.CompanionReviewEntity;
import io.renren.modules.companion.service.CompanionReviewService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-15 19:06:50
 */
@RestController
@RequestMapping("companion/companionreview")
public class CompanionReviewController {
    @Autowired
    private CompanionReviewService companionReviewService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companionReviewService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CompanionReviewEntity companionReview = companionReviewService.getById(id);

        return R.ok().put("companionReview", companionReview);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CompanionReviewEntity companionReview){
		companionReviewService.save(companionReview);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CompanionReviewEntity companionReview){
		companionReviewService.updateById(companionReview);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		companionReviewService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
