package io.renren.modules.shipping.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShippingOrderVO {

    /**
     * ID
     */
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
     * 订单状态描述
     */
    private String statusDesc;
}
