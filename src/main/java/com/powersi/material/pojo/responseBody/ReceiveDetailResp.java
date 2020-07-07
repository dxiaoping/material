package com.powersi.material.pojo.responseBody;

import java.math.BigDecimal;

public class ReceiveDetailResp {
    private String itemId;
    private String itemName;
    private BigDecimal latelyPrice;
    private BigDecimal currentPrice;
    private BigDecimal orderNumber;
    private BigDecimal arriveNumber;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

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

    public BigDecimal getLatelyPrice() {
        return latelyPrice;
    }

    public void setLatelyPrice(BigDecimal latelyPrice) {
        this.latelyPrice = latelyPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "ReceiveDetailResp{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", latelyPrice=" + latelyPrice +
                ", currentPrice=" + currentPrice +
                ", orderNumber=" + orderNumber +
                ", arriveNumber=" + arriveNumber +
                '}';
    }
}
