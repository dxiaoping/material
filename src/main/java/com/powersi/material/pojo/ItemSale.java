package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ItemSale {
    private String id;

    private String memberId;

    private String employeeId;

    private Date saleTime;

    private Integer saleRejectRemark;

    private BigDecimal saleAfterDiscount;

    private BigDecimal saleDiscountAmount;

    private BigDecimal saleTotalAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
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

    public BigDecimal getSaleTotalAmount() {
        return saleTotalAmount;
    }

    public void setSaleTotalAmount(BigDecimal saleTotalAmount) {
        this.saleTotalAmount = saleTotalAmount;
    }
}