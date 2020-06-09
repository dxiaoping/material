package com.powersi.material.mapper;

import com.powersi.material.pojo.Receive;
import com.powersi.material.pojo.ReceiveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiveMapper {
    int countByExample(ReceiveExample example);

    int deleteByExample(ReceiveExample example);

    int deleteByPrimaryKey(String id);

    int insert(Receive record);

    int insertSelective(Receive record);

    List<Receive> selectByExample(ReceiveExample example);

    Receive selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Receive record, @Param("example") ReceiveExample example);

    int updateByExample(@Param("record") Receive record, @Param("example") ReceiveExample example);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);
}