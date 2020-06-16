package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO类获得查询商品数据
 */

@Data
public class SearchItemDTO {

    private String id;

    private Integer itemClassId;

    private String itemClassName;

    private String itemName;

    private String itemUnit;

    private BigDecimal itemSalePrice;

    private String itemFactoryName;

    private Integer itemDiscState;

    private BigDecimal itemLatelyPic;

    private BigDecimal itemAverPic;

}
