package com.powersi.material.mapper;

import com.powersi.material.pojo.Supplier;
import com.powersi.material.pojo.SupplierExample;
import com.powersi.material.pojo.responseBody.SupplierResp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SupplierMapper {
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(String id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    @Select("SELECT\n" +
            "\tsi.supplier_id,\n" +
            "\ts.supplier_name,\n" +
            "\tsi.item_id,\n" +
            "\titem.item_name,\n" +
            "\tsi.in_price\n" +
            "FROM\n" +
            "\tsupplier_item si\n" +
            "INNER JOIN supplier s on si.supplier_id=s.id\n" +
            "INNER JOIN item on item.id=si.item_id")
    List<SupplierResp> findAllSuppliersSql();
}