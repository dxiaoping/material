package com.powersi.material.service;

import com.powersi.material.pojo.Supplier;
import com.powersi.material.pojo.SupplierItem;
import com.powersi.material.pojo.responseBody.SupplierResp;

import java.util.List;

public interface ISupplierService {
    public Supplier findByName(String name);
    public Supplier findSupplierById(String id);
    public List<Supplier> findAllSuppliers();
    public List<SupplierItem> findAllSupplierItems();
    //查询出supplierItem对象
    public SupplierItem findSupplierItemByPrimaryKey(String supplierId,String itemId);
    //更新价格
    public void updateInPice(SupplierItem supplierItem);

    public List<SupplierResp> findAllSuppliersSql();
}
