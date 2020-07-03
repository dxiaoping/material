package com.powersi.material.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.*;
import com.powersi.material.pojo.requestBody.OrderReq;
import com.powersi.material.pojo.requestBody.OrderReqList;
import com.powersi.material.pojo.responseBody.OrderResp;
import com.powersi.material.pojo.responseBody.ReceiveResp;
import com.powersi.material.service.*;
import com.powersi.material.utils.ListPageUtil;
import com.powersi.material.utils.PageBean;
import com.powersi.material.utils.SnowflakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    public static final int PAGE_SIZE = 5;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IReceiveService receiveService;
    @Autowired
    private IReceiveDetailService receiveDetailService;
    @Autowired
    private IEmployeeService employeeService;



    @RequestMapping("/dealOrderReq")
    public void dealOrderReq(@RequestBody OrderReqList orderReqList){


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

        Receive receive=new Receive();
        String receiveId=new Long(SnowflakeIdUtil.getSnowflakeId()).toString();
        //往收货表添加数据
        receive.setId(receiveId);
        receive.setEmployeeId(orderReqList.getEmployeeId());
        receive.setOrderId(orderId);
        receive.setReceOperDate(new Date());
        receive.setReceState(0);
        receiveService.insertReceive(receive);

        OrderDetail orderDetail=new OrderDetail();
        ReceiveDetail receiveDetail=new ReceiveDetail();
        for (OrderReq orderReq : list) {
            orderDetail.setItemId(orderReq.getId());
            orderDetail.setArriveNumber(new BigDecimal(orderReq.getItemNumber()));
//            orderDetail.setSupplierId(supplierService.findByName(orderReq.getItemFactoryName()).getId());
            orderDetail.setSupplierId(supplierService.findByName(orderReq.getSupplierName()).getId());
            orderDetail.setOrderId(orderId);
            orderDetail.setOrderNumber(new BigDecimal(orderReq.getItemNumber()));
            orderDetailService.insertOrderDetail(orderDetail);
            //往收货详情表添加数据
            receiveDetail.setReceId(receiveId);
            receiveDetail.setReceArriveNumber(new BigDecimal(0));
            receiveDetail.setItemId(orderReq.getId());
            receiveDetail.setSupplierId(supplierService.findByName(orderReq.getSupplierName()).getId());
            receiveDetailService.insertReceiveDetail(receiveDetail);
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

        return Double.parseDouble(orderService.findInPriceByItemIdAndSupplierName(itemId,supplierName));
    }
//返回到订货单明细页面封装的数据
    @RequestMapping("/backOrderResp")
    public List<OrderResp> backOrderResp(){
        List<OrderResp> orderResps=new ArrayList<>();

        List<OrderDetail> orderDetails = orderDetailService.findAll();
        for (OrderDetail orderDetail : orderDetails) {

            OrderResp orderResp=new OrderResp();
            orderResp.setId(orderDetail.getItemId());
            Item itemById = itemService.findItemById(orderDetail.getItemId());
            orderResp.setItemFactoryName(itemById.getItemFactoryName());
            orderResp.setItemLatelyPrice(itemById.getItemLatelyPic());
            orderResp.setItemName(itemById.getItemName());
            orderResp.setItemSpec(itemById.getItemSpec());
            orderResp.setOrderNumber(orderDetail.getOrderNumber());
            Supplier supplierById = supplierService.findSupplierById(orderDetail.getSupplierId());
            orderResp.setSupplierName(supplierById.getSupplierName());
            orderResps.add(orderResp);
        }
        return orderResps;
    }


    @RequestMapping("/backOrderRespByPage")
    public PageBean backOrderRespByPage(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
//        public ListPageUtil backOrderRespByPage(){
//        PageHelper.startPage(pageNum,PAGE_SIZE);
        List<OrderResp> orderResps=new ArrayList<>();

        List<OrderDetail> orderDetails = orderDetailService.findAll();
//        PageHelper.startPage(pageNum,PAGE_SIZE);
        for (OrderDetail orderDetail : orderDetails) {

            OrderResp orderResp=new OrderResp();
            orderResp.setId(orderDetail.getItemId());
            Item itemById = itemService.findItemById(orderDetail.getItemId());
            orderResp.setItemFactoryName(itemById.getItemFactoryName());
            orderResp.setItemLatelyPrice(itemById.getItemLatelyPic());
            orderResp.setItemName(itemById.getItemName());
            orderResp.setItemSpec(itemById.getItemSpec());
            orderResp.setOrderNumber(orderDetail.getOrderNumber());
            Supplier supplierById = supplierService.findSupplierById(orderDetail.getSupplierId());
            orderResp.setSupplierName(supplierById.getSupplierName());
            orderResps.add(orderResp);
        }

        /*System.out.println("orderDetails"+orderDetails.size());
        System.out.println(orderResps.size());
        PageInfo pageInfo=new PageInfo(orderResps);
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println(orderResps.size());
*/
        ListPageUtil<OrderResp> orderRespListPageUtil = new ListPageUtil<>(orderResps, PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(orderResps.size());
        pageBean.setPagedList(orderRespListPageUtil.getPagedList(pageNum));

        return pageBean;
    }

    @RequestMapping("/findOrderRespByExample")
//    public List<OrderResp> findOrderRespByExample(String itemId,String itemName){
    public PageBean findOrderRespByExample(String itemId,String itemName,@RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum){
        List<OrderResp> orderResps=new ArrayList<>();
        List<OrderDetail> orderDetails = orderDetailService.findByExample(itemId, itemName);
        for (OrderDetail orderDetail : orderDetails) {
            OrderResp orderResp=new OrderResp();
            orderResp.setId(orderDetail.getItemId());
            Item itemById = itemService.findItemById(orderDetail.getItemId());
            orderResp.setItemFactoryName(itemById.getItemFactoryName());
            orderResp.setItemLatelyPrice(itemById.getItemLatelyPic());
            orderResp.setItemName(itemById.getItemName());
            orderResp.setItemSpec(itemById.getItemSpec());
            orderResp.setOrderNumber(orderDetail.getOrderNumber());
            Supplier supplierById = supplierService.findSupplierById(orderDetail.getSupplierId());
            orderResp.setSupplierName(supplierById.getSupplierName());
            orderResps.add(orderResp);

        }
        ListPageUtil<OrderResp> orderRespListPageUtil = new ListPageUtil<>(orderResps, PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setPagedList(orderRespListPageUtil.getPagedList(pageNum));
        pageBean.setTotal(orderResps.size());

//        return orderResps;

        return pageBean;
    }












}
