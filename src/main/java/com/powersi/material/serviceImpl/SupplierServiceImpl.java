package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.SupplierMapper;
import com.powersi.material.pojo.Supplier;
import com.powersi.material.pojo.SupplierExample;
import com.powersi.material.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;
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
}
