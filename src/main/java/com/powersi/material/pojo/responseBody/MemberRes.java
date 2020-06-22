package com.powersi.material.pojo.responseBody;

import com.powersi.material.pojo.Member;
import com.powersi.material.pojo.MemberClass;

/**
 * @description: 收银台会员信息
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-17 15:11
 */
public class MemberRes {
    private Member member;
    private MemberClass memberClass;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberClass getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(MemberClass memberClass) {
        this.memberClass = memberClass;
    }
}
