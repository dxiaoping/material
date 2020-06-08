package com.powersi.material.mapper;

import com.powersi.material.pojo.MemberClass;

public interface MemberClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberClass record);

    int insertSelective(MemberClass record);

    MemberClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberClass record);

    int updateByPrimaryKey(MemberClass record);
}