package com.powersi.material.pojo.responseBody;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RepoRemainRes {
    //商品货号
    private String id;
    //商品名称
    private String itemName;
    //商品类别编号
    private Integer itemClassId;
    //商品类别名字
    private String itemClassName;
    //厂家名称
    private String itemFactoryName;
    //总库存量
    private BigDecimal totalRemain;
    //总成本
    private BigDecimal RemainAllInPic;
    //最近入库
    private Date inRepoDate;

}
