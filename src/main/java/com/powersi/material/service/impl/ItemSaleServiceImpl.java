package com.powersi.material.service.impl;
/**
 * @description: 销售单管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-9 10:34
 */

import com.powersi.material.mapper.ItemSaleDetailMapper;
import com.powersi.material.mapper.ItemSaleMapper;
import com.powersi.material.pojo.ItemSale;
import com.powersi.material.pojo.ItemSaleDetail;
import com.powersi.material.pojo.requestBody.SaleListReq;
import com.powersi.material.pojo.requestBody.SaleSettlementReq;
import com.powersi.material.service.IItemSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ItemSaleServiceImpl implements IItemSaleService {

    @Autowired
    ItemSaleMapper itemSaleMapper;

    @Autowired
    ItemSaleDetailMapper itemSaleDetailMapper;

    @Transactional
    @Override
    public int createSaleOrder(SaleSettlementReq saleSettlementReq) {

        ItemSale itemSale = saleSettlementReq.getItemSale();
        itemSale.setId(String.valueOf(Math.random()));
        itemSale.setSaleTime(new Date());
        itemSale.setSaleRejectRemark(1);

        List<ItemSaleDetail> itemSaleDetails = saleSettlementReq.getItemSaleDetails();
        for (ItemSaleDetail detail: itemSaleDetails) {
            detail.setItemSaleId(itemSale.getId());
            detail.setRepoId("仓库编号");
            detail.setSupplierId("供货商编号");
        }
        itemSaleMapper.insert(itemSale);
        itemSaleDetailMapper.insertSaleDetail(itemSaleDetails);
        return 0;
    }

    @Override
    public List getSaleList(SaleListReq saleListReq) {
        List saleList = null;
        if (saleListReq == null) {
            saleList = itemSaleMapper.selectByCondition(null, null, null);
        } else {
            saleList = itemSaleMapper.selectByCondition(saleListReq.getStartTime(), saleListReq.getEndTime(),
                    saleListReq.getKey() == null ? null : new StringBuffer("%").append(saleListReq.getKey()).append("%").toString());
        }
        return saleList;
    }

    @Override
    public List getSaleDetail(String itemSaleId) {

        List<ItemSaleDetail> details = itemSaleDetailMapper.selectBySaleId(itemSaleId);
        return details;
    }
}
