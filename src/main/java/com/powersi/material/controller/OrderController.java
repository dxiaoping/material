package com.powersi.material.controller;

import com.powersi.material.pojo.Order;
import com.powersi.material.pojo.OrderDetail;
import com.powersi.material.pojo.requestBody.OrderReq;
import com.powersi.material.pojo.requestBody.OrderReqList;
import com.powersi.material.service.IOrderDetailService;
import com.powersi.material.service.IOrderService;
import com.powersi.material.service.ISupplierService;
import com.powersi.material.utils.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private ISupplierService supplierService;



    @RequestMapping("/dealOrderReq")
    public void dealOrderReq(@RequestBody OrderReqList orderReqList){
        System.out.println("进来了啊啊啊啊啊啊啊啊");
        Double sumMoney=0d;
        List<OrderReq> list=orderReqList.getOrderReqList();
        for(int i=0;i<list.size();i++){
            sumMoney=sumMoney+(list.get(i).getInPrice()*list.get(i).getItemNumber());
        }

        Order order=new Order();
        String orderId=new Long(SnowflakeIdUtil.getSnowflakeId()).toString();
        order.setId(orderId);
        order.setEmployeeId(orderReqList.getEmployeeId());
        order.setOrderAmountMoney(new BigDecimal(sumMoney));
        order.setOrderIsArrive("未到达");
        order.setOrderOperDate(new Date());
        order.setOrdeStatus("未支付");
        orderService.insertOrder(order);

        OrderDetail orderDetail=new OrderDetail();
        for (OrderReq orderReq : list) {
            orderDetail.setItemId(orderReq.getId());
            orderDetail.setArriveNumber(new BigDecimal(orderReq.getItemNumber()));
//            orderDetail.setSupplierId(supplierService.findByName(orderReq.getItemFactoryName()).getId());
            orderDetail.setSupplierId(supplierService.findByName(orderReq.getSupplierName()).getId());
            orderDetail.setOrderId(orderId);
            orderDetail.setOrderNumber(new BigDecimal(orderReq.getItemNumber()));
            orderDetailService.insertOrderDetail(orderDetail);
        }

    }

    @RequestMapping("/findAllOrder")
    public List<Order> findAllOrder(){

        return orderService.findAll();
    }

    @RequestMapping("/findSupplierNameByItemId")
    public List<String> findSupplierNameByItemId(String itemId){
        return orderService.findSupplierNameByItemId(itemId);
    }

    @RequestMapping("/findInPriceByItemIdAndSupplierName")
    public Double  findInPriceByItemIdAndSupplierName( String itemId,String supplierName){
        System.out.println(itemId);
        System.out.println(supplierName);
        return Double.parseDouble(orderService.findInPriceByItemIdAndSupplierName(itemId,supplierName));
    }






}
