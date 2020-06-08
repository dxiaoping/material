package com.powersi.material.mapper;

import com.powersi.material.pojo.RepoRemain;

public interface RepoRemainMapper {
    int deleteByPrimaryKey(String id);

    int insert(RepoRemain record);

    int insertSelective(RepoRemain record);

    RepoRemain selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RepoRemain record);

    int updateByPrimaryKey(RepoRemain record);
}