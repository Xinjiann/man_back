package io.renren.modules.shipping.entity.param;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReviewParam {

    private Integer id;

    private BigDecimal price;

    private String orderNumber;

}
