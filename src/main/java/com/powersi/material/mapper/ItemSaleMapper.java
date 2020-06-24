package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemSale;
import com.powersi.material.pojo.ItemSaleExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ItemSaleMapper {

    List<ItemSale> selectByCondition(@Param("startTime") Date startTime,@Param("endTime")Date endTime,@Param("key")String key);

    int countByExample(ItemSaleExample example);

    int deleteByExample(ItemSaleExample example);

    int deleteByPrimaryKey(String id);

    int insert(ItemSale record);

    int insertSelective(ItemSale record);

    List<ItemSale> selectByExample(ItemSaleExample example);

    ItemSale selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ItemSale record, @Param("example") ItemSaleExample example);

    int updateByExample(@Param("record") ItemSale record, @Param("example") ItemSaleExample example);

    int updateByPrimaryKeySelective(ItemSale record);

    int updateByPrimaryKey(ItemSale record);
}
