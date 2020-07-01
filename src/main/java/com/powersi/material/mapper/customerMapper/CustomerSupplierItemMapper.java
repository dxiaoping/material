package com.powersi.material.mapper.customerMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerSupplierItemMapper {

    @Select("SELECT supplier_name FROM `supplier` WHERE id IN(SELECT supplier_id FROM `supplier_item` WHERE item_id=#{itemId})")
    public List<String> findSupplierNameByItemId(String itemId);

    @Select("SELECT in_price FROM `supplier_item` WHERE item_id=#{itemId} AND supplier_id=(SELECT id FROM `supplier` WHERE supplier_name=#{supplierName} )")
    public String findInPriceByItemIdAndSupplierName(@Param("itemId") String itemId, @Param("supplierName") String supplierName);
}
