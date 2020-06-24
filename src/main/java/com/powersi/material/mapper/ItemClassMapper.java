package com.powersi.material.mapper;

import com.powersi.material.pojo.ItemClass;
import com.powersi.material.pojo.ItemClassExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemClassMapper {
    int countByExample(ItemClassExample example);

    int deleteByExample(ItemClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemClass record);

    int insertSelective(ItemClass record);

    List<ItemClass> selectByExample(ItemClassExample example);

    ItemClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemClass record, @Param("example") ItemClassExample example);

    int updateByExample(@Param("record") ItemClass record, @Param("example") ItemClassExample example);

    int updateByPrimaryKeySelective(ItemClass record);

    int updateByPrimaryKey(ItemClass record);

    @Select("select * from item_class where item_class_father <> 0")
    List<ItemClass> selectAllItem();

}