package io.renren.modules.shipping.controller.client;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.Result;
import io.renren.modules.shipping.constant.ShippingOrderStatus;
import io.renren.modules.shipping.entity.po.ShippingOrderPO;
import io.renren.modules.shipping.entity.param.QueryOrderForPageParam;
import io.renren.modules.shipping.entity.param.SubmitOrderParam;
import io.renren.modules.shipping.service.ShippingOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @author lixinjian
 * @since 2023-03-08
 */
@RestController
@Slf4j
@RequestMapping("/client/shipping-order")
public class ShippingOrderController {

    @Resource
    private ShippingOrderService shippingOrderService;

    @PostMapping("/submit")
    public Result submit(@RequestBody SubmitOrderParam submitOrderParam) {
        /** 参数校验 */
        if (Objects.isNull(submitOrderParam.getAddress())) {
            return Result.fail("请输入地址");
        }
        if (Objects.isNull(submitOrderParam.getTrackingNumber())) {
            return Result.fail("请输入快递单号");
        }

        ShippingOrderPO shippingOrder = new ShippingOrderPO();
        shippingOrder.setAddress(submitOrderParam.getAddress());
        shippingOrder.setTrackingNumber(submitOrderParam.getTrackingNumber());
        shippingOrder.setRemark(submitOrderParam.getRemark());
        shippingOrder.setOpenid(submitOrderParam.getOpenid());
        shippingOrder.setCreateTime(new Date());
        shippingOrder.setStatus(ShippingOrderStatus.CREATED);
        shippingOrder.setDeleted(0);
        shippingOrderService.save(shippingOrder);
        return Result.success();
    }

    @PostMapping("/list")
    public Result list(@RequestBody QueryOrderForPageParam queryOrderForPageParam) {
        /** 参数校验 */
        if (Objects.isNull(queryOrderForPageParam.getPageParam())) {
            log.error("分页部件为空");
            return Result.fail();
        }
        if (Objects.isNull(queryOrderForPageParam.getOpenid())) {
            log.error("openid为空");
            return Result.fail();
        }

        QueryWrapper<ShippingOrderPO> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("openid", queryOrderForPageParam.getOpenid());
        Optional.ofNullable(queryOrderForPageParam.getStatus()).map(o->queryWrapper.eq("status", o));
        queryWrapper.eq("deleted", 0);
        Page<ShippingOrderPO> page = new Page(queryOrderForPageParam.getPageParam().getCurrent(), queryOrderForPageParam.getPageParam().getSize());
        IPage<ShippingOrderPO> res = shippingOrderService.page(page, queryWrapper);
        return Result.success(res);
    }
}
