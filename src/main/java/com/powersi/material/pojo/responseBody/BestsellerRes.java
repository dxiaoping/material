package com.powersi.material.pojo.responseBody;

import java.math.BigDecimal;

/**
 * @description: 畅销榜返回参数
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-29 17:25
 */
public class BestsellerRes {
    /**商品id*/
    private String itemId;
    /**商品名称*/
    private String itemName;
    /**商品类别*/
    private String itemClassName;
    /**销售数量*/
    private long totalNun;
    /**销售额*/
    private BigDecimal totalVolume;
    /**库存量*/
    private long stock;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemClassName() {
        return itemClassName;
    }

    public void setItemClassName(String itemClassName) {
        this.itemClassName = itemClassName;
    }

    public long getTotalNun() {
        return totalNun;
    }

    public void setTotalNun(long totalNun) {
        this.totalNun = totalNun;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(BigDecimal totalVolume) {
        this.totalVolume = totalVolume;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
