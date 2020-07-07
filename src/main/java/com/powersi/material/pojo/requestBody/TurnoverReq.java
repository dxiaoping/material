package com.powersi.material.pojo.requestBody;

import java.util.Date;
import java.util.List;

/**
 * @description: 营业额统计页面请求参数
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-24 13:45
 */
public class TurnoverReq {
    /** 起始时间*/
    private Date startTime;
    /** 截至时间*/
    private Date endTime;
    /** 查询周期*/
    private String cycle;
    /** 商品类别*/
    private List<Integer> itemClass;

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

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public List<Integer> getItemClass() {
        return itemClass;
    }

    public void setItemClass(List<Integer> itemClass) {
        this.itemClass = itemClass;
    }
}
