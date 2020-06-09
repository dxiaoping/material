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
        this.id = id == null ? null : id.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
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
        this.orderIsArrive = orderIsArrive == null ? null : orderIsArrive.trim();
    }

    public String getOrdeStatus() {
        return ordeStatus;
    }

    public void setOrdeStatus(String ordeStatus) {
        this.ordeStatus = ordeStatus == null ? null : ordeStatus.trim();
    }

    public BigDecimal getOrderAmountMoney() {
        return orderAmountMoney;
    }

    public void setOrderAmountMoney(BigDecimal orderAmountMoney) {
        this.orderAmountMoney = orderAmountMoney;
    }
}