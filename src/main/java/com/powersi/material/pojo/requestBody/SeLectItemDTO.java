package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SeLectItemDTO {

    private String id;

    private Integer itemClassId;

    private String itemName;

    private BigDecimal itemSalePrice1;

    private BigDecimal itemSalePrice2;

    private String itemFactoryName;

}
