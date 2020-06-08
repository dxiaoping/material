package com.powersi.material.pojo;

import java.math.BigDecimal;

public class ItemSaleDetail extends ItemSaleDetailKey {
    private BigDecimal salePrice;

    private Long saleNumber;

    private BigDecimal saleAfterDiscount;

    private BigDecimal saleDiscountAmount;

    private BigDecimal totalAmount;

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Long getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Long saleNumber) {
        this.saleNumber = saleNumber;
    }

    public BigDecimal getSaleAfterDiscount() {
        return saleAfterDiscount;
    }

    public void setSaleAfterDiscount(BigDecimal saleAfterDiscount) {
        this.saleAfterDiscount = saleAfterDiscount;
    }

    public BigDecimal getSaleDiscountAmount() {
        return saleDiscountAmount;
    }

    public void setSaleDiscountAmount(BigDecimal saleDiscountAmount) {
        this.saleDiscountAmount = saleDiscountAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}