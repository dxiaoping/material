package com.powersi.material.pojo.responseBody;

import java.math.BigDecimal;
import java.util.Date;

public class NewOrderResp {
    private String orderId;
    private String empName;
    private Date orderDate;
    private String isArrive;
    private String orderStatus;
    private BigDecimal orderAmountMoney;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getIsArrive() {
        return isArrive;
    }

    public void setIsArrive(String isArrive) {
        this.isArrive = isArrive;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderAmountMoney() {
        return orderAmountMoney;
    }

    public void setOrderAmountMoney(BigDecimal orderAmountMoney) {
        this.orderAmountMoney = orderAmountMoney;
    }
}
