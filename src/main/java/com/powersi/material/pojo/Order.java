package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String id;

    private String employeeId;

    private Date orderOperDate;

    private String orderIsArrive;

    private String ordeStatus;

    private BigDecimal orderAmountMoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOrderOperDate() {
        return orderOperDate;
    }

    public void setOrderOperDate(Date orderOperDate) {
        this.orderOperDate = orderOperDate;
    }

    public String getOrderIsArrive() {
        return orderIsArrive;
    }

    public void setOrderIsArrive(String orderIsArrive) {
        this.orderIsArrive = orderIsArrive;
    }

    public String getOrdeStatus() {
        return ordeStatus;
    }

    public void setOrdeStatus(String ordeStatus) {
        this.ordeStatus = ordeStatus;
    }

    public BigDecimal getOrderAmountMoney() {
        return orderAmountMoney;
    }

    public void setOrderAmountMoney(BigDecimal orderAmountMoney) {
        this.orderAmountMoney = orderAmountMoney;
    }
}