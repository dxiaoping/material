package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class InRepositoryDetailReq {

    //收货编号
    private String receId;
    //入库编号
    private String inRepoId;
    //货号  or 商品名称
    private String itemId;
    //供应商编号
    private String supplierId;
    //货源数量
    private BigDecimal inRepoNumber1;
    //货源数量
    private BigDecimal inRepoNumber2;
    //仓库编号
    private String repoId;

    private Integer inRepoState;
    private Integer pageNo;
    private Integer pageSize;

}
