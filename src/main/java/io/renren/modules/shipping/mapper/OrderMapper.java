package io.renren.modules.shipping.mapper;

import io.renren.modules.shipping.entity.po.ShippingOrderPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物流订单
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@Mapper
public interface OrderMapper extends BaseMapper<ShippingOrderPO> {
	
}
