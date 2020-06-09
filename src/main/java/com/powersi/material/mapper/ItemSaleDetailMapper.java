package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemSaleDetail;
import com.powersi.material.pojo.ItemSaleDetailExample;
import com.powersi.material.pojo.ItemSaleDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemSaleDetailMapper {
    int countByExample(ItemSaleDetailExample example);

    int deleteByExample(ItemSaleDetailExample example);

    int deleteByPrimaryKey(ItemSaleDetailKey key);

    int insert(ItemSaleDetail record);

    int insertSelective(ItemSaleDetail record);

    List<ItemSaleDetail> selectByExample(ItemSaleDetailExample example);

    ItemSaleDetail selectByPrimaryKey(ItemSaleDetailKey key);

    int updateByExampleSelective(@Param("record") ItemSaleDetail record, @Param("example") ItemSaleDetailExample example);

    int updateByExample(@Param("record") ItemSaleDetail record, @Param("example") ItemSaleDetailExample example);

    int updateByPrimaryKeySelective(ItemSaleDetail record);

    int updateByPrimaryKey(ItemSaleDetail record);
}