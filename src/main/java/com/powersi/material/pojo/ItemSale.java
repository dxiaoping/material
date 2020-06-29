package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ItemSale {
    /**销售编号*/
    private String id;
    /**会员编号*/
    private String memberId;
    /**员工编号*/
    private String employeeId;
    /**销售时间*/
    private Date saleTime;
    /**是否退货 0:退货 1:正常*/
    private Integer saleRejectRemark;
    /**折后价*/
    private BigDecimal saleAfterDiscount;
    /**优惠金额*/
    private BigDecimal saleDiscountAmount;
    /**总金额*/
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

    @Override
    public String toString() {
        return "ItemSale{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", saleTime=" + saleTime +
                ", saleRejectRemark=" + saleRejectRemark +
                ", saleAfterDiscount=" + saleAfterDiscount +
                ", saleDiscountAmount=" + saleDiscountAmount +
                ", saleTotalAmount=" + saleTotalAmount +
                '}';
    }
}
