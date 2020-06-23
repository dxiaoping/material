package com.powersi.material.pojo;

import java.math.BigDecimal;

public class ItemSaleDetail extends ItemSaleDetailKey {
    /**销售价格*/
    private BigDecimal salePrice;
    /**销售数量*/
    private Long saleNumber;
    /**折后价*/
    private BigDecimal saleAfterDiscount;
    /**优惠金额*/
    private BigDecimal saleDiscountAmount;
    /**总金额*/
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
