package com.powersi.material.pojo.requestBody;
/**
 * @description: 销售订单查询前端传入参数
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-9 10:34
 */
import java.util.Date;

public class SaleListReq {
//  查询起始时间
    private Date startTime;
    //  查询起始时间
    private Date endTime;
    //  订单号/操作人/顾客名
    private String key;
//    退货状态
    private int backSaleState;

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

    public int getBackSaleState() {
        return backSaleState;
    }

    public void setBackSaleState(int backSaleState) {
        this.backSaleState = backSaleState;
    }
}
