package com.powersi.material.mapper;

import com.powersi.material.pojo.Member;
import com.powersi.material.pojo.MemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    int countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(String memberTelp);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);
    List<Member> selectAll();

    Member selectByPrimaryKey(String memberTelp);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}
