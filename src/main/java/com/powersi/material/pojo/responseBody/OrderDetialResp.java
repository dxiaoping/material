package com.powersi.material.pojo.responseBody;

import java.math.BigDecimal;

public class OrderDetialResp {
    private String itemName;
    private String supplierName;
    private BigDecimal priceLately;
    private BigDecimal orderNumber;
    private String factoryName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getPriceLately() {
        return priceLately;
    }

    public void setPriceLately(BigDecimal priceLately) {
        this.priceLately = priceLately;
    }

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
