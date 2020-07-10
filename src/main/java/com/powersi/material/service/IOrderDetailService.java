package com.powersi.material.service;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.Order;
import com.powersi.material.pojo.OrderDetail;
import com.powersi.material.pojo.responseBody.OrderDetialResp;

import java.util.List;

public interface IOrderDetailService {
    public List<OrderDetail> findAll();

    public OrderDetail findOrderDetailById(String id);

    public void updateOrderDetail(OrderDetail orderDetail);

    public void deleteOrderDetailById(String id);

    public void insertOrderDetail(OrderDetail orderDetail);

    public List<OrderDetail> findByExample(String itemId,String itemName);

    public List<OrderDetail> findDetailListByOrderId(String orderId);

    //订单号和货号能确定唯一一个orderDetail对象，因此可以找出每个商品的订货数量
    public OrderDetail findByOrderIdAndItemId(String orderId,String itemId);


    public List<OrderDetialResp> findOrderDetailRespsByOrderId(String orderId);

}
