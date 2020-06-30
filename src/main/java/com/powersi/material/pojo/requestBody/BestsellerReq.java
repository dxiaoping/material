package com.powersi.material.pojo.requestBody;

import java.util.Date;

/**
 * @description: 畅销榜查询参数
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-29 17:23
 */
public class BestsellerReq {
    /** 起始时间*/
    private Date startTime;
    /** 截至时间*/
    private Date endTime;

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
}
