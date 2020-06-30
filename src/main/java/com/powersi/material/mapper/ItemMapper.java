package com.powersi.material.mapper;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemExample;
import com.powersi.material.pojo.requestBody.SeLectItemDTO;
import com.powersi.material.pojo.responseBody.SearchItemDTO;
import com.powersi.material.pojo.responseBody.SelectItemRes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
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

    List<SelectItemRes> selectItem(SeLectItemDTO example);

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

    @Select("select i.id from item i")
    List<String> selectAllItem();

    @Insert("insert into supplier_item (supplier_id,item_id,in_price) " +
            "values (#{supplier_id},#{item_id},#{in_price})")
    int insertST(@Param("supplier_id") String supplier_id,@Param("item_id") String item_id,@Param("in_price") BigDecimal in_price);

}
