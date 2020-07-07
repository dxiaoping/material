package com.powersi.material.pojo.requestBody;

import lombok.Data;

@Data
public class InRepoReq {

    private String employeeId;

    private InRepoListReq[] ilq;

}
