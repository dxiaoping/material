package com.powersi.material.service;
/**
 * @description: 销售单管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-9 10:34
 */
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemSaleDetail;
import com.powersi.material.pojo.requestBody.SaleListReq;
import com.powersi.material.pojo.requestBody.SaleSettlementReq;

import java.util.List;

public interface IItemSaleService {
    List getSaleList(SaleListReq saleListReq);
    int createSaleOrder(SaleSettlementReq saleSettlementReq);
    List getSaleDetail(String itemSaleId);
    int backSale(String id);
    List<Item> getAllItem();
    int createSaleOrderData(SaleSettlementReq saleSettlementReq);
}
