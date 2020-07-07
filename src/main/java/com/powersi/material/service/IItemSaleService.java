package com.powersi.material.service;

import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.requestBody.SaleListReq;
import com.powersi.material.pojo.requestBody.SaleSettlementReq;
import com.powersi.material.pojo.responseBody.SearchItem;

import java.util.Date;
import java.util.List;

public interface IItemSaleService {
    int createSaleOrder(SaleSettlementReq saleSettlementReq);
    List getSaleList(SaleListReq saleListReq);
    List getSaleDetail(String itemSaleId);
    int backSale(String id);
//    用于创建测试数据
    List<SearchItem> getAllItem(Date currentTime);
    int createSaleOrderData(SaleSettlementReq saleSettlementReq);
}
