package com.powersi.material.pojo.responseBody;

import com.powersi.material.pojo.RepoRemainDetail;

import java.math.BigDecimal;

/**
 * @description: 商品入库信息，用于接收计算成本的信息
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-07-07 18:28
 */
public class WarehouseInfo extends RepoRemainDetail {
//    入库数量
    private BigDecimal num;

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
