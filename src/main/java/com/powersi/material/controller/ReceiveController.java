package com.powersi.material.controller;

import com.powersi.material.pojo.Employee;
import com.powersi.material.pojo.OrderDetail;
import com.powersi.material.pojo.Receive;
import com.powersi.material.pojo.ReceiveDetail;
import com.powersi.material.pojo.responseBody.ReceiveDetailResp;
import com.powersi.material.pojo.responseBody.ReceiveResp;
import com.powersi.material.service.*;
import com.powersi.material.utils.ListPageUtil;
import com.powersi.material.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("rererererere"+receives.size());
        List<ReceiveResp> receiveRespList=new ArrayList<>();
//        ReceiveResp receiveResp=new ReceiveResp();不能放在这里最后只能插入同一个对象！！！！！！！！！！
        for (Receive receive : receives) {
            ReceiveResp receiveResp=new ReceiveResp();
            receiveResp.setOrderId(receive.getOrderId());
            Employee emp = employeeService.findEmpById(receive.getEmployeeId());
            receiveResp.setOrderPerson(emp.getEmpName());
            receiveResp.setReceiveDate(receive.getReceOperDate());
            receiveResp.setReceiveId(receive.getId());
            receiveResp.setReceivePerson("");
            receiveResp.setReceiveState("未收货");
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
        System.out.println("****************************"+receiveDetailList.size());
//        ReceiveDetailResp receiveDetailResp=new ReceiveDetailResp();不能放在这里最后只能插入同一个对象！！！！！！！！！！
        for (ReceiveDetail receiveDetail : receiveDetailList) {
            ReceiveDetailResp receiveDetailResp=new ReceiveDetailResp();
            receiveDetailResp.setArriveNumber(receiveDetail.getReceArriveNumber());
            String itemId=receiveDetail.getItemId();
            receiveDetailResp.setItemId(itemId);
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
}
