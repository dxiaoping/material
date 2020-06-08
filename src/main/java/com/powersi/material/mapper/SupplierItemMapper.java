package com.powersi.material.mapper;

import com.powersi.material.pojo.SupplierItem;
import com.powersi.material.pojo.SupplierItemKey;

public interface SupplierItemMapper {
    int deleteByPrimaryKey(SupplierItemKey key);

    int insert(SupplierItem record);

    int insertSelective(SupplierItem record);

    SupplierItem selectByPrimaryKey(SupplierItemKey key);

    int updateByPrimaryKeySelective(SupplierItem record);

    int updateByPrimaryKey(SupplierItem record);
}