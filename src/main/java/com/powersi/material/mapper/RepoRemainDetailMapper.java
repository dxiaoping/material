package com.powersi.material.mapper;

import com.powersi.material.pojo.RepoRemainDetail;
import com.powersi.material.pojo.RepoRemainDetailKey;

public interface RepoRemainDetailMapper {
    int deleteByPrimaryKey(RepoRemainDetailKey key);

    int insert(RepoRemainDetail record);

    int insertSelective(RepoRemainDetail record);

    RepoRemainDetail selectByPrimaryKey(RepoRemainDetailKey key);

    int updateByPrimaryKeySelective(RepoRemainDetail record);

    int updateByPrimaryKey(RepoRemainDetail record);
}