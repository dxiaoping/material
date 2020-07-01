package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RepoRemainReq {
    //商品编号
    private String id;
    //商品名称
    private String itemName;
    //商品类别编号
    private Integer itemClassId;
    //厂家名称
    private String itemFactoryName;
    //仓库编号
    private String repoId;
    //状态库存状态
    private String remainStatus;
    //库存的总数目
    private BigDecimal totalRemain;
}
