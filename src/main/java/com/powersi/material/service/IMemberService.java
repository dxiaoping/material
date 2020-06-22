package com.powersi.material.service;

import com.powersi.material.pojo.Member;
import com.powersi.material.pojo.MemberClass;
import com.powersi.material.pojo.responseBody.MemberRes;

import java.util.List;

public interface IMemberService {
    int save(Member member);
    int createRule(MemberClass memberClass);
    List getRuleList();
    List getMemberList();
    MemberRes getMemberInfo(String memberTelp);
    int updateMemberClass(List<MemberClass> list);
    int deleteMemberClass(Integer ruleId);
    int deleteMember(String memberTelp);
}
