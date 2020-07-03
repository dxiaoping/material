package com.powersi.material.pojo.responseBody;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class getRemainDetailRes {

    private Integer times;

    private BigDecimal remainAmount;

}
