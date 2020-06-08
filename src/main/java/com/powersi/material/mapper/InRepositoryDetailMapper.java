package com.powersi.material.mapper;

import com.powersi.material.pojo.InRepositoryDetail;
import com.powersi.material.pojo.InRepositoryDetailKey;

public interface InRepositoryDetailMapper {
    int deleteByPrimaryKey(InRepositoryDetailKey key);

    int insert(InRepositoryDetail record);

    int insertSelective(InRepositoryDetail record);

    InRepositoryDetail selectByPrimaryKey(InRepositoryDetailKey key);

    int updateByPrimaryKeySelective(InRepositoryDetail record);

    int updateByPrimaryKey(InRepositoryDetail record);
}