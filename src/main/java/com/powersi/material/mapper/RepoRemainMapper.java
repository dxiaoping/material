package com.powersi.material.mapper;

import com.powersi.material.pojo.RepoRemain;
import com.powersi.material.pojo.RepoRemainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepoRemainMapper {
    int countByExample(RepoRemainExample example);

    int deleteByExample(RepoRemainExample example);

    int deleteByPrimaryKey(String id);

    int insert(RepoRemain record);

    int insertSelective(RepoRemain record);

    List<RepoRemain> selectByExample(RepoRemainExample example);

    RepoRemain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RepoRemain record, @Param("example") RepoRemainExample example);

    int updateByExample(@Param("record") RepoRemain record, @Param("example") RepoRemainExample example);

    int updateByPrimaryKeySelective(RepoRemain record);

    int updateByPrimaryKey(RepoRemain record);
}