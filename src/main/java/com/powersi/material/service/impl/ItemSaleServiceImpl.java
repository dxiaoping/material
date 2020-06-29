package com.powersi.material.service.impl;
/**
 * @description: 销售单管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-9 10:34
 */

import com.powersi.material.commons.Id;
import com.powersi.material.mapper.*;
import com.powersi.material.pojo.*;
import com.powersi.material.pojo.requestBody.SaleListReq;
import com.powersi.material.pojo.requestBody.SaleSettlementReq;
import com.powersi.material.pojo.responseBody.SaleItemDeatilRes;
import com.powersi.material.service.IItemSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemSaleServiceImpl implements IItemSaleService {

    @Autowired
    ItemSaleMapper itemSaleMapper;

    @Autowired
    ItemSaleDetailMapper itemSaleDetailMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    RepoMapper repoMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @Transactional
    @Override
    public int createSaleOrder(SaleSettlementReq saleSettlementReq) {
        Id idWorker = new Id(0, 0);
        ItemSale itemSale = saleSettlementReq.getItemSale();
        itemSale.setId(String.valueOf(idWorker.nextId()));
        itemSale.setSaleTime(new Date());
        itemSale.setSaleRejectRemark(1);

        List<ItemSaleDetail> itemSaleDetails = saleSettlementReq.getItemSaleDetails();
        for (ItemSaleDetail detail: itemSaleDetails) {
            detail.setItemSaleId(itemSale.getId());
            detail.setRepoId("1");
            detail.setSupplierId("1");
            detail.setSaleRejectRemark(1);
            detail.setSaleTime(itemSale.getSaleTime());
        }
        itemSaleMapper.insert(itemSale);
        itemSaleDetailMapper.insertSaleDetail(itemSaleDetails);
        return 0;
    }

    @Override
    public List getSaleList(SaleListReq saleListReq) {
        List saleList = null;
        if (saleListReq == null) {
            saleList = itemSaleMapper.selectByCondition(null, null, null,2);
        } else {
            saleList = itemSaleMapper.selectByCondition(saleListReq.getStartTime(), saleListReq.getEndTime(),
                    saleListReq.getKey() == null ? null : new StringBuffer("%").append(saleListReq.getKey()).append("%").toString(),
                    saleListReq.getBackSaleState());
        }
        return saleList;
    }

    @Override
    public List getSaleDetail(String itemSaleId) {
        List<SaleItemDeatilRes> deatilRes = new ArrayList<>();
        List<ItemSaleDetail> details = itemSaleDetailMapper.selectBySaleId(itemSaleId);
        for (ItemSaleDetail detail: details) {
            SaleItemDeatilRes saleItemDeatilRes = new SaleItemDeatilRes();
            Item item = itemMapper.selectByPrimaryKey(detail.getItemId());
            Repo repo = repoMapper.selectByPrimaryKey(detail.getRepoId());
            Supplier supplier = supplierMapper.selectByPrimaryKey(detail.getSupplierId());
            saleItemDeatilRes.setItem(item);
            saleItemDeatilRes.setItemSaleDetail(detail);
            saleItemDeatilRes.setRepo(repo);
            saleItemDeatilRes.setSupplier(supplier);
            deatilRes.add(saleItemDeatilRes);
        }
        return deatilRes;
    }

    @Override
    public int backSale(String id) {
        ItemSale itemSale = new ItemSale();
        itemSale.setId(id);
        itemSale.setSaleRejectRemark(0);
        itemSaleMapper.updateByPrimaryKeySelective(itemSale);
//        退货后不再取消，故写死 SaleRejectRemark=0
        itemSaleDetailMapper.updateBySaleId(id);
        return 0;
    }

    @Override
    public List<Item> getAllItem() {
        return itemSaleMapper.getAllItem();
    }

//    用于创建测试数据
    @Transactional
    @Override
    public int createSaleOrderData(SaleSettlementReq saleSettlementReq) {
        Id idWorker = new Id(0, 0);
        ItemSale itemSale = saleSettlementReq.getItemSale();
        itemSale.setId(String.valueOf(idWorker.nextId()));
        itemSale.setSaleRejectRemark(1);

        List<ItemSaleDetail> itemSaleDetails = saleSettlementReq.getItemSaleDetails();
        for (ItemSaleDetail detail: itemSaleDetails) {
            detail.setItemSaleId(itemSale.getId());
            detail.setRepoId("1");
            detail.setSupplierId("1");
            detail.setSaleRejectRemark(1);
            detail.setSaleTime(itemSale.getSaleTime());
        }
        itemSaleMapper.insert(itemSale);
        itemSaleDetailMapper.insertSaleDetail(itemSaleDetails);
        return 0;
    }
}
