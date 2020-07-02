package com.powersi.material.pojo.responseBody;

import java.util.Date;

public class ReceiveResp {

    private String receiveId;
    private String orderId;
    private Date receiveDate;
    private String orderPerson;
    private String receivePerson;
    private String receiveState;

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson;
    }

    public String getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
    }

    public String getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState;
    }

    @Override
    public String toString() {
        return "ReceiveResp{" +
                "receiveId='" + receiveId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", receiveDate=" + receiveDate +
                ", orderPerson='" + orderPerson + '\'' +
                ", receivePerson='" + receivePerson + '\'' +
                ", receiveState='" + receiveState + '\'' +
                '}';
    }
}
