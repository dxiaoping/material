package com.powersi.material.pojo.responseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RepoRemainRes {
    //商品货号  i
    private String id;
    //商品名称  i
    private String itemName;
    //商品类别编号   i
    private Integer itemClassId;
    //商品类别名字  ic   不查
    private String itemClassName;
    //厂家名称   i
    private String itemFactoryName;
    //总库存量  rr
    private BigDecimal totalRemain;
    //总成本   count(rrd.repo_remain_in_pic)
    private BigDecimal RemainAllInPic;
    //最近入库   rrd
    @JsonFormat(pattern="yyyy年MM月dd日 HH时mm分")
    private Date inRepoDate;

    private String repoName = "一号仓库";

}
