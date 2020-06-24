package com.powersi.material.pojo;

public class MemberClass {
    private String id;

    private String memberClassName;

    private Float memberClassDiscount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberClassName() {
        return memberClassName;
    }

    public void setMemberClassName(String memberClassName) {
        this.memberClassName = memberClassName == null ? null : memberClassName.trim();
    }

    public Float getMemberClassDiscount() {
        return memberClassDiscount;
    }

    public void setMemberClassDiscount(Float memberClassDiscount) {
        this.memberClassDiscount = memberClassDiscount;
    }
}
