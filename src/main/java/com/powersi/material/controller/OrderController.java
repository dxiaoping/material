package com.powersi.material.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.*;
import com.powersi.material.pojo.requestBody.OrderReq;
import com.powersi.material.pojo.requestBody.OrderReqList;
import com.powersi.material.pojo.responseBody.NewOrderResp;
import com.powersi.material.pojo.responseBody.OrderDetialResp;
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
        /*long randomNum=SnowflakeIdUtil.getSnowflakeId();
        String orderId=new Long(randomNum).toString();*/
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
       //receive.setEmployeeId(orderReqList.getEmployeeId());
        receive.setEmployeeId("");
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

   /* @RequestMapping("/findAllOrder")
    public List<Order> findAllOrder(){

        return orderService.findAll();
    }*/

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

        ListPageUtil<OrderResp> orderRespListPageUtil = new ListPageUtil<>(orderResps, PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(orderResps.size());
        pageBean.setPagedList(orderRespListPageUtil.getPagedList(pageNum));

        return pageBean;
    }

    //sql形式封装到dto中提高查询性能
    @RequestMapping("/backOrderRespsByPageSql")
    public PageBean backOrderRespsByPageSql(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
        List<OrderResp> orderResps = orderService.findAllOrderResp();
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

    //查询所有订单数据
    @RequestMapping("/findAllOrder")
    public PageBean findAllOrder(@RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum){
        List<Order> orders = orderService.findAll();
        List<NewOrderResp> list=new ArrayList<>();
        for (Order order : orders) {

            NewOrderResp orderResp=new NewOrderResp();
            System.out.println("yyyy"+order.getEmployeeId());
            String empName=employeeService.findEmpById(order.getEmployeeId()).getEmpName();
            orderResp.setEmpName(empName);
            orderResp.setIsArrive(order.getOrderIsArrive());
            orderResp.setOrderAmountMoney(order.getOrderAmountMoney());
            orderResp.setOrderDate(order.getOrderOperDate());
            orderResp.setOrderId(order.getId());
            orderResp.setOrderStatus(order.getOrdeStatus());
            list.add(orderResp);
        }
        ListPageUtil listPageUtil=new ListPageUtil(list,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(list.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        return pageBean;
    }

    @RequestMapping("/findAllNewOrderRespBySql")
    public PageBean findAllNewOrderRespBySql(@RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum){
        List<NewOrderResp> newOrderResps = orderService.findAllNewOrderResps();
        ListPageUtil listPageUtil=new ListPageUtil(newOrderResps,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(newOrderResps.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        return pageBean;

    }

    @RequestMapping("/findOrderDetailRespByOrderId")
    public PageBean findOrderDetailRespByOrderId(String orderId,@RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum){
        System.out.println("jfiaojfoajfoajfoajfa"+orderId);
        List<OrderDetail> detailList = orderDetailService.findDetailListByOrderId(orderId);
        System.out.println("detailList"+detailList.size());
        List<OrderDetialResp> orderDetialResps=new ArrayList<>();
        for (OrderDetail orderDetail : detailList) {
            OrderDetialResp orderDetialResp=new OrderDetialResp();
            orderDetialResp.setSupplierName(supplierService.findSupplierById(orderDetail.getSupplierId()).getSupplierName());
            Item item=itemService.findItemById(orderDetail.getItemId());
            orderDetialResp.setFactoryName(item.getItemFactoryName());
            orderDetialResp.setItemName(item.getItemName());
            orderDetialResp.setOrderNumber(orderDetail.getOrderNumber());
            orderDetialResp.setPriceLately(item.getItemLatelyPic());
            orderDetialResps.add(orderDetialResp);


        }
        ListPageUtil listPageUtil=new ListPageUtil(orderDetialResps,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(orderDetialResps.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        return pageBean;

    }
    //sql方式的实现上述代码
    @RequestMapping("/findOrderDetailRespByOrderIdSqL")
    public PageBean findOrderDetailRespByOrderIdSqL(String orderId,@RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum){

        List<OrderDetialResp> orderDetialResps = orderDetailService.findOrderDetailRespsByOrderId(orderId);
        ListPageUtil listPageUtil=new ListPageUtil(orderDetialResps,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setTotal(orderDetialResps.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        return pageBean;

    }














}
