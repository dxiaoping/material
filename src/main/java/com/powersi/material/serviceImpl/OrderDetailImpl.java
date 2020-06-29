package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.OrderDetailMapper;
import com.powersi.material.pojo.OrderDetail;
import com.powersi.material.pojo.OrderDetailExample;
import com.powersi.material.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailMapper.selectByExample(null);
    }

    @Override
    public OrderDetail findOrderDetailById(String id) {

        OrderDetailExample example=new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(id);
        List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(example);
        return orderDetails.get(0);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {

        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Override
    public void deleteOrderDetailById(String id) {

        OrderDetailExample example=new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(id);
        orderDetailMapper.deleteByExample(example);
    }

    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {

        orderDetailMapper.insert(orderDetail);
    }
}
