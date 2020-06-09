package com.powersi.material.pojo;

public class InRepositoryDetailKey {
    private String supplierId;

    private String itemId;

    private String inRepoId;

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

    public String getInRepoId() {
        return inRepoId;
    }

    public void setInRepoId(String inRepoId) {
        this.inRepoId = inRepoId == null ? null : inRepoId.trim();
    }
}