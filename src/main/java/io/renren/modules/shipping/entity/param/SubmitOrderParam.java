package io.renren.modules.shipping.entity.param;

import lombok.Data;

@Data
public class SubmitOrderParam {

    /**
     * 快递单号
     */
    private String trackingNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 描述
     */
    private String remark;

    /**
     * 操作人openid
     */
    private String openid;


}
