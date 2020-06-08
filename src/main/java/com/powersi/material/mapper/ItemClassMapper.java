package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemClass;

public interface ItemClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemClass record);

    int insertSelective(ItemClass record);

    ItemClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemClass record);

    int updateByPrimaryKey(ItemClass record);
}