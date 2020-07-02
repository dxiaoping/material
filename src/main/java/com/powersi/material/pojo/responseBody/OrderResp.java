package com.powersi.material.pojo.responseBody;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderResp implements Serializable {
    private String id;
    private String itemName;
    private String itemSpec;
    private BigDecimal itemLatelyPrice;
    private BigDecimal orderNumber;
    private String itemFactoryName;
    private String supplierName;

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

    public BigDecimal getItemLatelyPrice() {
        return itemLatelyPrice;
    }

    public void setItemLatelyPrice(BigDecimal itemLatelyPrice) {
        this.itemLatelyPrice = itemLatelyPrice;
    }

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemFactoryName() {
        return itemFactoryName;
    }

    public void setItemFactoryName(String itemFactoryName) {
        this.itemFactoryName = itemFactoryName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "OrderResp{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemSpec='" + itemSpec + '\'' +
                ", itemLatelyPrice=" + itemLatelyPrice +
                ", orderNumber=" + orderNumber +
                ", itemFactoryName='" + itemFactoryName + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}
