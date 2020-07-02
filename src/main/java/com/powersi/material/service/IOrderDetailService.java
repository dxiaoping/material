package com.powersi.material.service;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.Order;
import com.powersi.material.pojo.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    public List<OrderDetail> findAll();

    public OrderDetail findOrderDetailById(String id);

    public void updateOrderDetail(OrderDetail orderDetail);

    public void deleteOrderDetailById(String id);

    public void insertOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> findByExample(String itemId,String itemName);


}
