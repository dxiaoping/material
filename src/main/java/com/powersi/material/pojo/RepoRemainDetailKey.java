package com.powersi.material.pojo;

public class RepoRemainDetailKey {
    private String repoRemainId;

    private String supplierId;
    private int times;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getRepoRemainId() {
        return repoRemainId;
    }

    public void setRepoRemainId(String repoRemainId) {
        this.repoRemainId = repoRemainId == null ? null : repoRemainId.trim();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }
}
