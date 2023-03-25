package io.renren.modules.shipping.controller;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.renren.common.constant.ShippingOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.shipping.entity.ShippingOrderEntity;
import io.renren.modules.shipping.service.OrderService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 物流订单
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@RestController
@RequestMapping("shipping/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 筛选列表
     */
    @RequestMapping("/getStatusOrderList")
    public R getCreatedOrderList(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryStatusOrderForPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ShippingOrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShippingOrderEntity order){
		orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShippingOrderEntity order){
		orderService.updateById(order);

        return R.ok();
    }

    /**
     * 驳回
     */
    @RequestMapping("/reject")
    public R delete(@RequestBody Integer[] ids){
        for (int id : ids) {
            ShippingOrderEntity order = orderService.getById(id);
            order.setStatus(ShippingOrderStatus.INVALID);
            orderService.updateById(order);
        }
        return R.ok();
    }


}
