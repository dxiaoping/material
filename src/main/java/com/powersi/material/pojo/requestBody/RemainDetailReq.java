package com.powersi.material.pojo.requestBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RemainDetailReq {

    //货号编号
    private String id;
    // 供应商编号   rrd
    private String supplierId;
    //入库时间范围
//    @JsonFormat(pattern="yyyy年MM月dd日 HH时mm分")
    private Date[] inRepoDate;
    //批次        rrd
    private Integer times;
    //库存情况      rrd
    private Integer remainStatus;
    //库存数量      rrd
    private Integer totalRemain;

    private Integer pageNo;

    private Integer pageSize;
}
