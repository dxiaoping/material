package com.powersi.material.pojo;

import java.math.BigDecimal;

public class InRepositoryDetail extends InRepositoryDetailKey {
    private String repoId;

    private Integer times;

    private BigDecimal inRepoNumber;

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public BigDecimal getInRepoNumber() {
        return inRepoNumber;
    }

    public void setInRepoNumber(BigDecimal inRepoNumber) {
        this.inRepoNumber = inRepoNumber;
    }
}