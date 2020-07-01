package com.powersi.material.service;

import com.powersi.material.pojo.Order;

import java.util.List;

public interface IOrderService {

    public List<Order> findAll();

    public Order findOrderById(String id);

    public void updateOrder(Order order);

    public void deleteOrderById(String id);

    public void insertOrder(Order order);

    public List<String> findSupplierNameByItemId(String itemId);

    public String findInPriceByItemIdAndSupplierName(String itemId,String supplierName);
}
