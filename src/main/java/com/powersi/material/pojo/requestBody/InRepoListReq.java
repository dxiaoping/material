package com.powersi.material.pojo.requestBody;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InRepoListReq {

    private String inRepoId;
    private String itemId;
    private BigDecimal itemLatelyPic;
    private String supplierId;
    private BigDecimal needInRepoNumber;
    private String repoId;
    private BigDecimal inRepoNumber;

}
