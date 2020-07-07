package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.Date;

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
    /**销售时间*/
    private Date saleTime;
    /**是否退货 0:退货 1:正常*/
    private Integer saleRejectRemark;
    /**供货商-批次-数量*/
    private String batch;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

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

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Integer getSaleRejectRemark() {
        return saleRejectRemark;
    }

    public void setSaleRejectRemark(Integer saleRejectRemark) {
        this.saleRejectRemark = saleRejectRemark;
    }

    @Override
    public String toString() {
        return "ItemSaleDetail{" +
                "salePrice=" + salePrice +
                ", saleNumber=" + saleNumber +
                ", saleAfterDiscount=" + saleAfterDiscount +
                ", saleDiscountAmount=" + saleDiscountAmount +
                ", totalAmount=" + totalAmount +
                ", saleTime=" + saleTime +
                ", saleRejectRemark=" + saleRejectRemark +
                '}';
    }
}
