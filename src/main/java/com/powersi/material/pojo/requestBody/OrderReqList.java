package com.powersi.material.pojo.requestBody;

import java.util.List;

public class OrderReqList {

    private String employeeId;

    private List<OrderReq> orderReqList;

    public List<OrderReq> getOrderReqList() {
        return orderReqList;
    }

    public void setOrderReqList(List<OrderReq> orderReqList) {
        this.orderReqList = orderReqList;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
