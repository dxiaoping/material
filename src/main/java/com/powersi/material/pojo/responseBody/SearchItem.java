package com.powersi.material.pojo.responseBody;

import com.powersi.material.pojo.Item;

import java.math.BigDecimal;

/**
 * @description: 商品销售搜索
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-07-06 17:29
 */
public class SearchItem extends Item {
    /**库存*/
    private BigDecimal stock;

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
