package com.powersi.material.pojo.responseBody;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InRepositoryDetailRes {

    //货号
    private String itemId;
    //商品名称
    private String itemName;
    //供应商名称
    private String supplierId;
    //供应商名称
    private String supplierName;
    //货源数量
    private BigDecimal ItemsNumber;
    //单价
    private BigDecimal itemLatelyPic;
    //仓库名字
    private String repoName;
    //已入库批次
//    private Integer times;

}
