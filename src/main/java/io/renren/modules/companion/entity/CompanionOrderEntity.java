package io.renren.modules.companion.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-15 19:06:50
 */
@Data
@TableName("companion_order")
public class CompanionOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * openid
	 */
	private String user;
	/**
	 * playmate id
	 */
	private Integer playmate;
	/**
	 * game id
	 */
	private Integer game;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 总时间
	 */
	private Integer period;
	/**
	 * 总价格
	 */
	private BigDecimal amount;
	/**
	 * 下单时间
	 */
	private Date createTime;
	/**
	 * 删除标志
	 */
	private Integer delete;

}
