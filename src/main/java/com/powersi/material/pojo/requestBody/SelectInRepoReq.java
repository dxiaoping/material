package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.util.Date;

@Data
public class SelectInRepoReq {

    //入库 或 收货 编号
    private String id;
    //员工编号  或  名字
    private String employeeId;
    //入库时间
    private Date[] inRepoDate;
    //入库状态
    private Integer inRepoState;
    //页数
    private Integer pageNo;
    //页大小
    private Integer pageSize;

}
