package com.powersi.material.pojo.requestBody;

import java.math.BigDecimal;

public class OrderReq {
    //货号
    private String id;

    private String itemName;

    private String itemSpec;

    private String itemUnit;

    private Double itemSalePrice;

    private Long itemNumber;

    private String itemFactoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public Double getItemSalePrice() {
        return itemSalePrice;
    }

    public void setItemSalePrice(Double itemSalePrice) {
        this.itemSalePrice = itemSalePrice;
    }

    public Long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemFactoryName() {
        return itemFactoryName;
    }

    public void setItemFactoryName(String itemFactoryName) {
        this.itemFactoryName = itemFactoryName;
    }
}
