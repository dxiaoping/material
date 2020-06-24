package com.powersi.material.mapper;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemExample;
import com.powersi.material.pojo.requestBody.SearchItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ItemMapper {

    @Select("select i.id,\n" +
            "i.item_class_id,\n" +
            "concat((select itc.item_class_name from item_class itc where itc.id = ic.item_class_father),' / ',ic.item_class_name) as item_class_name,\n" +
            "i.item_name,\n" +
            "concat(i.item_spec,' / ',i.item_unit) as item_unit,\n" +
            "i.item_sale_price,\n" +
            "i.item_factory_name,\n" +
            "i.item_lately_pic,\n" +
            "i.item_aver_pic,\n" +
            "i.item_disc_state\n" +
            "from item i,item_class ic \n" +
            "where i.item_class_id = ic.id\n" +
            "and (i.item_name like concat('%',#{itemName},'%') \n" +
            "or i.id like concat('%',#{itemName},'%') )")
    List<SearchItemDTO> selectByItemName(@Param("itemName") String itemName);

    List<Item> selectByKeyWord(@Param("keyWord") String keyWord);

    @Select("select i.id,\n" +
            "i.item_class_id,\n" +
            "concat((select itc.item_class_name from item_class itc where itc.id = ic.item_class_father),' / ',ic.item_class_name) as item_class_name,\n" +
            "i.item_name,\n" +
            "concat(i.item_spec,' / ',i.item_unit) as item_unit,\n" +
            "i.item_sale_price,\n" +
            "i.item_factory_name,\n" +
            "i.item_lately_pic,\n" +
            "i.item_aver_pic,\n" +
            "i.item_disc_state\n" +
            "from item i,item_class ic \n" +
            "where i.item_class_id = ic.id\n" +
            "and ((i.item_name like concat('%',#{itemName},'%') or i.id like concat('%',#{itemName},'%') )\n" +
            "and (ic.id = #{itemClass} or ic.item_class_father = #{itemClass} ))")
    List<SearchItemDTO> selectByItemNameAndClass(@Param("itemName") String itemName,@Param("itemClass") String itemClass);

    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}
