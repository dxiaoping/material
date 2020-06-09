package com.powersi.material.mapper;

import com.powersi.material.pojo.MemberClass;
import com.powersi.material.pojo.MemberClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberClassMapper {
    int countByExample(MemberClassExample example);

    int deleteByExample(MemberClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberClass record);

    int insertSelective(MemberClass record);

    List<MemberClass> selectByExample(MemberClassExample example);

    MemberClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberClass record, @Param("example") MemberClassExample example);

    int updateByExample(@Param("record") MemberClass record, @Param("example") MemberClassExample example);

    int updateByPrimaryKeySelective(MemberClass record);

    int updateByPrimaryKey(MemberClass record);
}