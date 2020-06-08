package com.powersi.material.mapper;

import com.powersi.material.pojo.InRepository;

public interface InRepositoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(InRepository record);

    int insertSelective(InRepository record);

    InRepository selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InRepository record);

    int updateByPrimaryKey(InRepository record);
}