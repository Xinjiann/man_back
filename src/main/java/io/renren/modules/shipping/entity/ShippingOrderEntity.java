package io.renren.modules.shipping.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物流订单
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@Data
@TableName("shipping_order")
public class ShippingOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 描述
	 */
	private String remark;
	/**
	 * 快递单号
	 */
	private String trackingNumber;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 创建者
	 */
	private String openid;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 金额
	 */
	private BigDecimal price;
	/**
	 * 国际单号
	 */
	private String orderNumber;
	/**
	 * 图片key
	 */
	private String image;
	/**
	 * 订单状态
	 */
	private Integer status;
	/**
	 * 删除标志
	 */
	private Integer deleted;

}
