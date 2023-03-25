package io.renren.modules.shipping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageRes;
import io.renren.common.utils.PageUtils;
import io.renren.modules.shipping.entity.po.ShippingOrderPO;
import io.renren.modules.shipping.entity.vo.ShippingOrderVO;

import java.util.Map;

/**
 * 物流订单
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
public interface ShippingOrderService extends IService<ShippingOrderPO> {

    PageRes<ShippingOrderVO> queryPage(Map<String, Object> params);

    PageRes<ShippingOrderVO> queryStatusOrderForPage(Map<String, Object> params);

    void updateImage(Long id, String newFileName);
}

