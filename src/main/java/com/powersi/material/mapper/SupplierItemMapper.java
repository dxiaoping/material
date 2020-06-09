package com.powersi.material.mapper;

import com.powersi.material.pojo.SupplierItem;
import com.powersi.material.pojo.SupplierItemExample;
import com.powersi.material.pojo.SupplierItemKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierItemMapper {
    int countByExample(SupplierItemExample example);

    int deleteByExample(SupplierItemExample example);

    int deleteByPrimaryKey(SupplierItemKey key);

    int insert(SupplierItem record);

    int insertSelective(SupplierItem record);

    List<SupplierItem> selectByExample(SupplierItemExample example);

    SupplierItem selectByPrimaryKey(SupplierItemKey key);

    int updateByExampleSelective(@Param("record") SupplierItem record, @Param("example") SupplierItemExample example);

    int updateByExample(@Param("record") SupplierItem record, @Param("example") SupplierItemExample example);

    int updateByPrimaryKeySelective(SupplierItem record);

    int updateByPrimaryKey(SupplierItem record);
}