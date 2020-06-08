package com.powersi.material.pojo;

import java.math.BigDecimal;

public class SupplierItem extends SupplierItemKey {
    private BigDecimal inPrice;

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }
}