package io.renren.modules.shipping.entity.param;

import io.renren.common.utils.PageParam;
import lombok.Data;

@Data
public class QueryOrderForPageParam {

    /**
     * openid
     */
    private String openid;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 分页部件
     */
    private PageParam pageParam;
}
