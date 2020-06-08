package com.powersi.material.mapper;

import com.powersi.material.pojo.Receive;

public interface ReceiveMapper {
    int deleteByPrimaryKey(String id);

    int insert(Receive record);

    int insertSelective(Receive record);

    Receive selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);
}