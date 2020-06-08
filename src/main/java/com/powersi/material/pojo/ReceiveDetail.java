package com.powersi.material.pojo;

import java.math.BigDecimal;

public class ReceiveDetail extends ReceiveDetailKey {
    private BigDecimal receArriveNumber;

    public BigDecimal getReceArriveNumber() {
        return receArriveNumber;
    }

    public void setReceArriveNumber(BigDecimal receArriveNumber) {
        this.receArriveNumber = receArriveNumber;
    }
}