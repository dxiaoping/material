package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.OrderMapper;
import com.powersi.material.mapper.customerMapper.CustomerSupplierItemMapper;
import com.powersi.material.pojo.Order;
import com.powersi.material.pojo.responseBody.NewOrderResp;
import com.powersi.material.pojo.responseBody.OrderResp;
import com.powersi.material.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private CustomerSupplierItemMapper customerSupplierItemMapper;


    @Override
    public List<Order> findAll() {
        return orderMapper.selectByExample(null);
    }

    @Override
    public Order findOrderById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateOrder(Order order) {

        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void deleteOrderById(String id) {

        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertOrder(Order order) {

        orderMapper.insert(order);
    }

    @Override
    public List<String> findSupplierNameByItemId(String itemId) {
        return customerSupplierItemMapper.findSupplierNameByItemId(itemId);
    }

    @Override
    public String findInPriceByItemIdAndSupplierName(String itemId, String supplierName) {
        return customerSupplierItemMapper.findInPriceByItemIdAndSupplierName(itemId,supplierName);
    }

    @Override
    public List<NewOrderResp> findAllNewOrderResps() {
        return orderMapper.findAllNewOrderResps();
    }

    @Override
    public List<OrderResp> findAllOrderResp() {
        return orderMapper.findAllOrderResp();
    }
}
