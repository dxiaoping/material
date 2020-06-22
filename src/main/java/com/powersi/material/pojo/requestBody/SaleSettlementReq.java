package com.powersi.material.pojo.requestBody;

import com.powersi.material.pojo.ItemSale;
import com.powersi.material.pojo.ItemSaleDetail;

import java.util.List;

/**
 * @description: 收银台结算参数
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-18 11:09
 */
public class SaleSettlementReq {
    private ItemSale itemSale;
    private List<ItemSaleDetail> itemSaleDetails;

    public ItemSale getItemSale() {
        return itemSale;
    }

    public void setItemSale(ItemSale itemSale) {
        this.itemSale = itemSale;
    }

    public List<ItemSaleDetail> getItemSaleDetails() {
        return itemSaleDetails;
    }

    public void setItemSaleDetails(List<ItemSaleDetail> itemSaleDetails) {
        this.itemSaleDetails = itemSaleDetails;
    }
}
