package com.powersi.material.mapper;

import com.powersi.material.pojo.ReceiveDetail;
import com.powersi.material.pojo.ReceiveDetailKey;

public interface ReceiveDetailMapper {
    int deleteByPrimaryKey(ReceiveDetailKey key);

    int insert(ReceiveDetail record);

    int insertSelective(ReceiveDetail record);

    ReceiveDetail selectByPrimaryKey(ReceiveDetailKey key);

    int updateByPrimaryKeySelective(ReceiveDetail record);

    int updateByPrimaryKey(ReceiveDetail record);
}