package com.powersi.material.mapper;

import com.powersi.material.pojo.Repo;

public interface RepoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Repo record);

    int insertSelective(Repo record);

    Repo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Repo record);

    int updateByPrimaryKey(Repo record);
}