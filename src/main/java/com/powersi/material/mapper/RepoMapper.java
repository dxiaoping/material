package com.powersi.material.mapper;

import com.powersi.material.pojo.Repo;
import com.powersi.material.pojo.RepoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepoMapper {
    int countByExample(RepoExample example);

    int deleteByExample(RepoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Repo record);

    int insertSelective(Repo record);

    List<Repo> selectByExample(RepoExample example);

    Repo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Repo record, @Param("example") RepoExample example);

    int updateByExample(@Param("record") Repo record, @Param("example") RepoExample example);

    int updateByPrimaryKeySelective(Repo record);

    int updateByPrimaryKey(Repo record);
}