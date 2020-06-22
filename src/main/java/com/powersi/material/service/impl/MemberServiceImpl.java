package com.powersi.material.service.impl;

import com.powersi.material.mapper.MemberClassMapper;
import com.powersi.material.mapper.MemberMapper;
import com.powersi.material.pojo.Member;
import com.powersi.material.pojo.MemberClass;
import com.powersi.material.pojo.responseBody.MemberRes;
import com.powersi.material.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @description: 会员管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-11 10:00
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberClassMapper memberClassMapper;

    @Override
    public int save(Member member) {
        if (memberMapper.selectByPrimaryKey(member.getMemberTelp()) == null) {
            member.setMemberRegTime(new Date());
            return memberMapper.insert(member);
        } else {
            return memberMapper.updateByPrimaryKeySelective(member);
        }
    }

    @Override
    public int createRule(MemberClass memberClass) {
        memberClass.setId(""+new Random().nextInt());
        return memberClassMapper.insert(memberClass);
    }

    @Override
    public List getRuleList() {
        return memberClassMapper.selectAll();
    }

    @Override
    public List getMemberList() {
        return memberMapper.selectAll();
    }

    @Override
    public MemberRes getMemberInfo(String memberTelp) {
        Member member = memberMapper.selectByPrimaryKey(memberTelp);
        MemberClass memberClass = null;
        if (member != null) {
            memberClass = memberClassMapper.selectByPrimaryKey(member.getMemberClassId());
        }
        MemberRes memberRes = new MemberRes();
        memberRes.setMember(member);
        memberRes.setMemberClass(memberClass);
        return memberRes;
    }

    @Override
    public int updateMemberClass(List<MemberClass> list) {
        for (MemberClass memberClass : list) {
            memberClassMapper.updateByPrimaryKey(memberClass);
        }
        return 0;
    }

    @Override
    public int deleteMemberClass(Integer ruleId) {
        return memberClassMapper.deleteByPrimaryKey(ruleId);

    }

    @Override
    public int deleteMember(String memberTelp) {
        return memberMapper.deleteByPrimaryKey(memberTelp);
    }
}
