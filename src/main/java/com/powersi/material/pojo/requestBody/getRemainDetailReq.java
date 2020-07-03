package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class getRemainDetailReq {

    private String id;

    private BigDecimal totalRemain;

    private Date[] inRepoDate;

    private Integer supplierId;

}
