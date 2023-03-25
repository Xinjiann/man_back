package io.renren.modules.shipping.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingOrderStatusEnum {

    CREATED(1, "待审核"),
    WAITING_FOR_PAID(2, "待付款"),
    INVALID(3, "已驳回"),
    FINISHED(4, "已付款");

    int code;
    String msg;

    /**
     * 通过code获取msg
     *
     * @param code
     * @return
     */
    public static String getMsg(int code) {

        for (ShippingOrderStatusEnum entry : values()) {//values()类似于map的迭代时的Entry
            if (code == entry.getCode()) {
                return entry.getMsg();
            }
        }
        throw new IllegalArgumentException("枚举类型异常");
    }

    /**
     * 通过msg获取code
     *
     * @param msg
     * @return
     */
    public static int getCode(String msg) {

        for (ShippingOrderStatusEnum entry : values()) {//values()类似于map的迭代时的Entry
            if (msg.equals(entry.getMsg())) {
                return entry.getCode();
            }
        }
        throw new IllegalArgumentException("枚举类型异常");
    }
}
