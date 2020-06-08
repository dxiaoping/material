package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
    private String memberTelp;

    private String memberClassId;

    private String memberName;

    private String memberIdNum;

    private Date memberRegTime;

    private BigDecimal memberAmountMoney;

    public String getMemberTelp() {
        return memberTelp;
    }

    public void setMemberTelp(String memberTelp) {
        this.memberTelp = memberTelp;
    }

    public String getMemberClassId() {
        return memberClassId;
    }

    public void setMemberClassId(String memberClassId) {
        this.memberClassId = memberClassId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberIdNum() {
        return memberIdNum;
    }

    public void setMemberIdNum(String memberIdNum) {
        this.memberIdNum = memberIdNum;
    }

    public Date getMemberRegTime() {
        return memberRegTime;
    }

    public void setMemberRegTime(Date memberRegTime) {
        this.memberRegTime = memberRegTime;
    }

    public BigDecimal getMemberAmountMoney() {
        return memberAmountMoney;
    }

    public void setMemberAmountMoney(BigDecimal memberAmountMoney) {
        this.memberAmountMoney = memberAmountMoney;
    }
}