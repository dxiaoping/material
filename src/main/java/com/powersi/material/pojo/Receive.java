package com.powersi.material.pojo;

import java.util.Date;

public class Receive {
    private String id;

    private String orderId;

    private String employeeId;

    private Date receOperDate;

    private Integer receState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public Date getReceOperDate() {
        return receOperDate;
    }

    public void setReceOperDate(Date receOperDate) {
        this.receOperDate = receOperDate;
    }

    public Integer getReceState() {
        return receState;
    }

    public void setReceState(Integer receState) {
        this.receState = receState;
    }
}