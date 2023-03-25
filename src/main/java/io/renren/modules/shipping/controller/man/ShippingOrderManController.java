package io.renren.modules.shipping.controller.man;

import java.util.Map;

import io.renren.common.utils.PageRes;
import io.renren.modules.shipping.constant.ShippingOrderStatus;
import io.renren.modules.shipping.entity.vo.ShippingOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.shipping.entity.po.ShippingOrderPO;
import io.renren.modules.shipping.service.ShippingOrderService;
import io.renren.common.utils.R;



/**
 * 物流订单
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@RestController
@RequestMapping("shipping_man/order")
public class ShippingOrderManController {
    @Autowired
    private ShippingOrderService shippingOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageRes<ShippingOrderVO> page = shippingOrderService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 筛选列表
     */
    @RequestMapping("/getStatusOrderList")
    public R getCreatedOrderList(@RequestParam Map<String, Object> params){
        PageRes<ShippingOrderVO> page = shippingOrderService.queryStatusOrderForPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ShippingOrderPO order = shippingOrderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShippingOrderPO order){
		shippingOrderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShippingOrderPO order){
		shippingOrderService.updateById(order);

        return R.ok();
    }

    /**
     * 驳回
     */
    @RequestMapping("/reject")
    public R delete(@RequestBody Integer[] ids){
        for (int id : ids) {
            ShippingOrderPO order = shippingOrderService.getById(id);
            order.setStatus(ShippingOrderStatus.INVALID);
            shippingOrderService.updateById(order);
        }
        return R.ok();
    }


}
