package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemSale;
import com.powersi.material.pojo.ItemSaleExample;
import com.powersi.material.pojo.responseBody.SearchItem;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ItemSaleMapper {

    List<ItemSale> selectByCondition(@Param("startTime") Date startTime,@Param("endTime")Date endTime,@Param("key")String key,@Param("backSaleState") int backSaleState);

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

    List<SearchItem> getAllItem(Date currentTime);
}
