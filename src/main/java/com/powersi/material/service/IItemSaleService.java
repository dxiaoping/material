package com.powersi.material.service;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.requestBody.SaleListReq;
import com.powersi.material.pojo.requestBody.SaleSettlementReq;

import java.util.List;

public interface IItemSaleService {
    int createSaleOrder(SaleSettlementReq saleSettlementReq);
    List getSaleList(SaleListReq saleListReq);
    List getSaleDetail(String itemSaleId);
    int backSale(String id);
    List<Item> getAllItem();
    int createSaleOrderData(SaleSettlementReq saleSettlementReq);
}
