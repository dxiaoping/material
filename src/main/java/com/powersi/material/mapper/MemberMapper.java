package com.powersi.material.mapper;

import com.powersi.material.pojo.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String memberTelp);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String memberTelp);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}