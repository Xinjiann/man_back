package io.renren.modules.shipping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.shipping.entity.ShippingOrderEntity;

import java.util.Map;

/**
 * 物流订单
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
public interface OrderService extends IService<ShippingOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryStatusOrderForPage(Map<String, Object> params);
}

