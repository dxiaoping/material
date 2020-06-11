package com.powersi.material.pojo.requestBody;

import java.util.Date;

//销售订单查询前端传入参数
public class SaleListParam {
//  查询起始时间
    private Date startTime;
    //  查询起始时间
    private Date endTime;
    //  订单号/操作人/顾客名
    private String key;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
