package com.powersi.material.pojo.responseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SelectInRepoRes {

    //入库单号  in
    private String id;
    //收货单号  in
    private String receiveId;
    //收货人员  re
    private String employeeId1;
    //入库人员  in
    private String employeeId2;
    //收货人员名字  em
    private String empName1;
    //入库人员名字    em
    private String empName2;
    //入库状态  in
    private Integer inRepoState;
    //入库时间  in
    @JsonFormat(pattern="yyyy年MM月dd日 HH时mm分")
    private Date inRepoDate;

}
