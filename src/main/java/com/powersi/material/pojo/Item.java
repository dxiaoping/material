package com.powersi.material.pojo;

import java.math.BigDecimal;

public class Item {
    private String id;

    private Integer itemClassId;

    private String itemCode;

    private String itemName;

    private String itemSpell;

    private String itemWubi;

    private String itemSpec;

    private String itemUnit;

    private BigDecimal itemSalePrice;

    private String itemFactoryName;

    private Integer itemDiscState;

    private BigDecimal itemLatelyPic;

    private BigDecimal itemAverPic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getItemClassId() {
        return itemClassId;
    }

    public void setItemClassId(Integer itemClassId) {
        this.itemClassId = itemClassId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpell() {
        return itemSpell;
    }

    public void setItemSpell(String itemSpell) {
        this.itemSpell = itemSpell;
    }

    public String getItemWubi() {
        return itemWubi;
    }

    public void setItemWubi(String itemWubi) {
        this.itemWubi = itemWubi;
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

    public BigDecimal getItemSalePrice() {
        return itemSalePrice;
    }

    public void setItemSalePrice(BigDecimal itemSalePrice) {
        this.itemSalePrice = itemSalePrice;
    }

    public String getItemFactoryName() {
        return itemFactoryName;
    }

    public void setItemFactoryName(String itemFactoryName) {
        this.itemFactoryName = itemFactoryName;
    }

    public Integer getItemDiscState() {
        return itemDiscState;
    }

    public void setItemDiscState(Integer itemDiscState) {
        this.itemDiscState = itemDiscState;
    }

    public BigDecimal getItemLatelyPic() {
        return itemLatelyPic;
    }

    public void setItemLatelyPic(BigDecimal itemLatelyPic) {
        this.itemLatelyPic = itemLatelyPic;
    }

    public BigDecimal getItemAverPic() {
        return itemAverPic;
    }

    public void setItemAverPic(BigDecimal itemAverPic) {
        this.itemAverPic = itemAverPic;
    }
}