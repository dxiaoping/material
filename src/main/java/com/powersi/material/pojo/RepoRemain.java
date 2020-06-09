package com.powersi.material.pojo;

import java.math.BigDecimal;

public class RepoRemain {
    private String id;

    private String repoId;

    private String itemId;

    private BigDecimal totalRemain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId == null ? null : repoId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public BigDecimal getTotalRemain() {
        return totalRemain;
    }

    public void setTotalRemain(BigDecimal totalRemain) {
        this.totalRemain = totalRemain;
    }
}