package com.powersi.material.pojo.responseBody;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 营业额统计返回
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-24 16:41
 */
public class TurnoverRes {

    /**时间*/
    private String dateTime;
    /**成本*/
    private BigDecimal cost;
    /**销售额*/
    private BigDecimal saleVolume;
    /**销售数量*/
    private long saleNum;
    /**总利润*/
    private BigDecimal profit;
    /**成本增长*/
    private BigDecimal costIncrease;
    /**销售额增长*/
    private BigDecimal saleVolumeIncrease;
    /**销售数量增长*/
    private BigDecimal saleNumIncrease;
    /**总利润增长*/
    private BigDecimal profitIncrease;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(BigDecimal saleVolume) {
        this.saleVolume = saleVolume;
    }

    public long getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(long saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getCostIncrease() {
        return costIncrease;
    }

    public void setCostIncrease(BigDecimal costIncrease) {
        this.costIncrease = costIncrease;
    }

    public BigDecimal getSaleVolumeIncrease() {
        return saleVolumeIncrease;
    }

    public void setSaleVolumeIncrease(BigDecimal saleVolumeIncrease) {
        this.saleVolumeIncrease = saleVolumeIncrease;
    }

    public BigDecimal getSaleNumIncrease() {
        return saleNumIncrease;
    }

    public void setSaleNumIncrease(BigDecimal saleNumIncrease) {
        this.saleNumIncrease = saleNumIncrease;
    }

    public BigDecimal getProfitIncrease() {
        return profitIncrease;
    }

    public void setProfitIncrease(BigDecimal profitIncrease) {
        this.profitIncrease = profitIncrease;
    }

    @Override
    public String toString() {
        return "TurnoverRes{" +
                "dateTime='" + dateTime + '\'' +
                ", cost=" + cost +
                ", saleVolume=" + saleVolume +
                ", saleNum=" + saleNum +
                ", profit=" + profit +
                ", costIncrease=" + costIncrease +
                ", saleVolumeIncrease=" + saleVolumeIncrease +
                ", saleNumIncrease=" + saleNumIncrease +
                ", profitIncrease=" + profitIncrease +
                '}';
    }
}
