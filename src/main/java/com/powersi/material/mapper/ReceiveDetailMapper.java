package com.powersi.material.mapper;

import com.powersi.material.pojo.ReceiveDetail;
import com.powersi.material.pojo.ReceiveDetailExample;
import com.powersi.material.pojo.ReceiveDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiveDetailMapper {
    int countByExample(ReceiveDetailExample example);

    int deleteByExample(ReceiveDetailExample example);

    int deleteByPrimaryKey(ReceiveDetailKey key);

    int insert(ReceiveDetail record);

    int insertSelective(ReceiveDetail record);

    List<ReceiveDetail> selectByExample(ReceiveDetailExample example);

    ReceiveDetail selectByPrimaryKey(ReceiveDetailKey key);

    int updateByExampleSelective(@Param("record") ReceiveDetail record, @Param("example") ReceiveDetailExample example);

    int updateByExample(@Param("record") ReceiveDetail record, @Param("example") ReceiveDetailExample example);

    int updateByPrimaryKeySelective(ReceiveDetail record);

    int updateByPrimaryKey(ReceiveDetail record);
}