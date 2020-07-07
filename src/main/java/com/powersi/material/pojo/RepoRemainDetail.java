package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class RepoRemainDetail extends RepoRemainDetailKey {

    private Integer remainAmount;

    private BigDecimal repoRemainInPic;

    private Date inRepoDate;


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

    public Date getInRepoDate() {
        return inRepoDate;
    }

    public void setInRepoDate(Date inRepoDate) {
        this.inRepoDate = inRepoDate;
    }

}
