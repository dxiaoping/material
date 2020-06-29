package com.powersi.material.pojo.responseBody;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO类获得查询商品数据
 */

@Data
public class SelectItemRes {

    private String id;

    private Integer itemClassId;

    private String itemClassName;

    private String itemName;

    private BigDecimal itemSalePrice;

    private String itemFactoryName;

}
