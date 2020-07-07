package com.powersi.material.controller;

import com.powersi.material.pojo.*;
import com.powersi.material.pojo.responseBody.ReceiveDetailResp;
import com.powersi.material.pojo.responseBody.ReceiveResp;
import com.powersi.material.service.*;
import com.powersi.material.utils.ListPageUtil;
import com.powersi.material.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/receive")
public class ReceiveController {
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
    @RequestMapping("/findReceiveResp")
    public PageBean findReceiveResp(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
        List<Receive> receives=receiveService.findAll();
        List<ReceiveResp> receiveRespList=new ArrayList<>();
//        ReceiveResp receiveResp=new ReceiveResp();不能放在这里最后只能插入同一个对象！！！！！！！！！！
        for (Receive receive : receives) {
            ReceiveResp receiveResp=new ReceiveResp();
            receiveResp.setOrderId(receive.getOrderId());
            Order order = orderService.findOrderById(receive.getOrderId());
            Employee emp = employeeService.findEmpById(order.getEmployeeId());
            receiveResp.setOrderPerson(emp.getEmpName());
            receiveResp.setReceiveDate(receive.getReceOperDate());
            receiveResp.setReceiveId(receive.getId());
            if(receive.getEmployeeId().equals("")){
                receiveResp.setReceivePerson("");
            }else {
                receiveResp.setReceivePerson(employeeService.findEmpById(receive.getEmployeeId()).getEmpName());
            }
            if(receive.getReceState()==0){
                receiveResp.setReceiveState("未收货");
            }else {
                receiveResp.setReceiveState("已到货");
            }


            receiveRespList.add(receiveResp);

        }
        ListPageUtil listPageUtil=new ListPageUtil(receiveRespList,PAGE_SIZE);
        PageBean pageBean=new PageBean();
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));
        pageBean.setTotal(receiveRespList.size());
        return pageBean;
    }

    @RequestMapping("/findReceiveDetailByReceiveId")
//    public List<ReceiveDetailResp> findReceiveDetailByReceiveId(String receiveId){
    public PageBean findReceiveDetailByReceiveId(String receiveId,@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
        List<ReceiveDetailResp> receiveDetailRespList =new ArrayList<>();
        List<ReceiveDetail> receiveDetailList = receiveDetailService.findRecDetailByRecId(receiveId);
//        ReceiveDetailResp receiveDetailResp=new ReceiveDetailResp();不能放在这里最后只能插入同一个对象！！！！！！！！！！
        for (ReceiveDetail receiveDetail : receiveDetailList) {
            ReceiveDetailResp receiveDetailResp=new ReceiveDetailResp();
            receiveDetailResp.setArriveNumber(receiveDetail.getReceArriveNumber());
            String itemId=receiveDetail.getItemId();
            receiveDetailResp.setItemId(itemId);
            //c查询出当前价格
            String inPrice = orderService.findInPriceByItemIdAndSupplierName(receiveDetail.getItemId(), supplierService.findSupplierById(receiveDetail.getSupplierId()).getSupplierName());
            receiveDetailResp.setCurrentPrice(new BigDecimal(Double.parseDouble(inPrice)));
            //查询出最近价格
            Item itemById = itemService.findItemById(receiveDetail.getItemId());
            receiveDetailResp.setLatelyPrice(itemById.getItemLatelyPic());
            receiveDetailResp.setItemName(itemService.findItemById(itemId).getItemName());
            String orderId=receiveService.findRecByRecId(receiveId).getOrderId();
            OrderDetail orderDetail = orderDetailService.findByOrderIdAndItemId(orderId, itemId);
            receiveDetailResp.setOrderNumber(orderDetail.getOrderNumber());
            receiveDetailRespList.add(receiveDetailResp);

        }
        PageBean pageBean=new PageBean();
        ListPageUtil listPageUtil=new ListPageUtil(receiveDetailRespList,PAGE_SIZE);
        pageBean.setTotal(receiveDetailRespList.size());
        pageBean.setPagedList(listPageUtil.getPagedList(pageNum));

        return pageBean;

    }

    @RequestMapping("/confirmReceive")
    public void confirmReceive(String receiveId,String empId){

        Receive rec = receiveService.findRecByRecId(receiveId);
        rec.setReceState(1);
        rec.setEmployeeId(empId);
        receiveService.updateRec(rec);
        List<ReceiveDetail> receiveDetails = receiveDetailService.findRecDetailByRecId(receiveId);
        for (ReceiveDetail receiveDetail : receiveDetails) {
            //修改最近价格为这一次的进货价
            Item item = itemService.findItemById(receiveDetail.getItemId());
            String inPrice = orderService.findInPriceByItemIdAndSupplierName(receiveDetail.getItemId(), supplierService.findSupplierById(receiveDetail.getSupplierId()).getSupplierName());
            item.setItemLatelyPic(new BigDecimal(Double.parseDouble(inPrice)));
            itemService.updateItem(item);

            //订单号和货号能确定唯一一个orderDetail对象，因此可以找出每个商品的订货数量
            OrderDetail orderDetail = orderDetailService.findByOrderIdAndItemId(rec.getOrderId(), receiveDetail.getItemId());
            receiveDetail.setReceArriveNumber(orderDetail.getOrderNumber());
            receiveDetailService.updateReceiveDetail(receiveDetail);
        }


    }
}
