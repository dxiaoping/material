package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemSale;

public interface ItemSaleMapper {
    int deleteByPrimaryKey(String id);

    int insert(ItemSale record);

    int insertSelective(ItemSale record);

    ItemSale selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ItemSale record);

    int updateByPrimaryKey(ItemSale record);
}