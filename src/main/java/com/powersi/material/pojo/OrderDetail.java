package com.powersi.material.pojo;

import java.math.BigDecimal;

public class OrderDetail extends OrderDetailKey {
    private BigDecimal orderNumber;

    private BigDecimal arriveNumber;

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getArriveNumber() {
        return arriveNumber;
    }

    public void setArriveNumber(BigDecimal arriveNumber) {
        this.arriveNumber = arriveNumber;
    }
}