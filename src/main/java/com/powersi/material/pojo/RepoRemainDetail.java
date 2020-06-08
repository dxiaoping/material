package com.powersi.material.pojo;

import java.math.BigDecimal;

public class RepoRemainDetail extends RepoRemainDetailKey {
    private Integer times;

    private Integer remainAmount;

    private BigDecimal repoRemainInPic;

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Integer remainAmount) {
        this.remainAmount = remainAmount;
    }

    public BigDecimal getRepoRemainInPic() {
        return repoRemainInPic;
    }

    public void setRepoRemainInPic(BigDecimal repoRemainInPic) {
        this.repoRemainInPic = repoRemainInPic;
    }
}