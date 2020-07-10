package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.SupplierItemMapper;
import com.powersi.material.mapper.SupplierMapper;
import com.powersi.material.pojo.Supplier;
import com.powersi.material.pojo.SupplierExample;
import com.powersi.material.pojo.SupplierItem;
import com.powersi.material.pojo.SupplierItemKey;
import com.powersi.material.pojo.responseBody.SupplierResp;
import com.powersi.material.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private SupplierItemMapper supplierItemMapper;
    @Override
    public Supplier findByName(String name) {
        SupplierExample example=new SupplierExample();
        SupplierExample.Criteria criteria = example.createCriteria();
        criteria.andSupplierNameEqualTo(name);
        List<Supplier> list=supplierMapper.selectByExample(example);
        if(list!=null&&list.size()!=0){
            return supplierMapper.selectByExample(example).get(0);
        }else {
            System.out.println("未查询到数据，集合为空");
            return null;
        }


    }

    @Override
    public Supplier findSupplierById(String id) {
        return supplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        return supplierMapper.selectByExample(null);
    }

    @Override
    public List<SupplierItem> findAllSupplierItems() {
        return supplierItemMapper.selectByExample(null);
    }

    @Override
    public SupplierItem findSupplierItemByPrimaryKey(String supplierId,String itemId) {
        SupplierItemKey supplierItemKey=new SupplierItemKey();
        supplierItemKey.setItemId(itemId);
        supplierItemKey.setSupplierId(supplierId);
        return supplierItemMapper.selectByPrimaryKey(supplierItemKey);
    }

    @Override
    public void updateInPice(SupplierItem supplierItem) {

        supplierItemMapper.updateByPrimaryKey(supplierItem);
    }

    @Override
    public List<SupplierResp> findAllSuppliersSql() {
        return supplierMapper.findAllSuppliersSql();
    }
}
