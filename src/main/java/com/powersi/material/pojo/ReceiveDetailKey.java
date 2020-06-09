package com.powersi.material.pojo;

public class ReceiveDetailKey {
    private String receId;

    private String supplierId;

    private String itemId;

    public String getReceId() {
        return receId;
    }

    public void setReceId(String receId) {
        this.receId = receId == null ? null : receId.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }
}