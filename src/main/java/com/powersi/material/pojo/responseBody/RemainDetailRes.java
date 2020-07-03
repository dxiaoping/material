package com.powersi.material.pojo.responseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RemainDetailRes {
    //批次    rrd
    private Integer times;
    //价格    rrd
    private BigDecimal repoRemainInPic;
    //数量    rrd
    private BigDecimal remainAmount;
    //供应商名字     s
    private String supplierName;
    //入库时间      rrd
    @JsonFormat(pattern="yyyy年MM月dd日 HH时mm分")
    private Date inRepoDate;

}

