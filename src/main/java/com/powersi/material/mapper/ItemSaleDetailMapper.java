package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemSaleDetail;
import com.powersi.material.pojo.ItemSaleDetailKey;

public interface ItemSaleDetailMapper {
    int deleteByPrimaryKey(ItemSaleDetailKey key);

    int insert(ItemSaleDetail record);

    int insertSelective(ItemSaleDetail record);

    ItemSaleDetail selectByPrimaryKey(ItemSaleDetailKey key);

    int updateByPrimaryKeySelective(ItemSaleDetail record);

    int updateByPrimaryKey(ItemSaleDetail record);
}