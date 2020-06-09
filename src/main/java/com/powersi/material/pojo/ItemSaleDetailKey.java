package com.powersi.material.pojo;

public class ItemSaleDetailKey {
    private String itemSaleId;

    private String itemId;

    private String repoId;

    private String supplierId;

    public String getItemSaleId() {
        return itemSaleId;
    }

    public void setItemSaleId(String itemSaleId) {
        this.itemSaleId = itemSaleId == null ? null : itemSaleId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId == null ? null : repoId.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }
}