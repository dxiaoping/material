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
import com.powersi.material.pojo.responseBody.SearchItem;
import com.powersi.material.service.IItemSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    RepoRemainMapper repoRemainMapper;

    @Autowired
    RepoRemainDetailMapper repoRemainDetailMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    MemberMapper memberMapper;

    @Transactional
    @Override
    public int createSaleOrder(SaleSettlementReq saleSettlementReq) {
        Id idWorker = new Id(0, 0);
        ItemSale itemSale = saleSettlementReq.getItemSale();
        itemSale.setId(String.valueOf(idWorker.nextId()));
        itemSale.setSaleTime(new Date());
        itemSale.setSaleRejectRemark(1);

        if (itemSale.getMemberId() != null && !itemSale.getMemberId().equals("")) {
            Member member = memberMapper.selectByPrimaryKey(itemSale.getMemberId());
            BigDecimal money = member.getMemberAmountMoney().add(itemSale.getSaleTotalAmount());
            member.setMemberAmountMoney(money);
            memberMapper.updateByPrimaryKeySelective(member);
        }

        List<ItemSaleDetail> itemSaleDetails = saleSettlementReq.getItemSaleDetails();
        for (ItemSaleDetail detail : itemSaleDetails) {
            StringBuffer itemFrom = reduceStock(detail);
            detail.setItemSaleId(itemSale.getId());
            detail.setRepoId("1");
            detail.setSupplierId("1");
            detail.setSaleRejectRemark(1);
            detail.setSaleTime(itemSale.getSaleTime());
            detail.setBatch(itemFrom.toString());
        }
        itemSaleMapper.insert(itemSale);
        itemSaleDetailMapper.insertSaleDetail(itemSaleDetails);
        return 0;
    }

    @Override
    public List getSaleList(SaleListReq saleListReq) {
        List saleList = null;
        if (saleListReq == null) {
            saleList = itemSaleMapper.selectByCondition(null, null, null, 2);
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
        for (ItemSaleDetail detail : details) {
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
        List<ItemSaleDetail> itemSaleDetails = itemSaleDetailMapper.selectBySaleId(id);
        for (ItemSaleDetail itemSaleDetail : itemSaleDetails) {
            addStock(itemSaleDetail);
        }
//        退货后不再取消，故写死 SaleRejectRemark=0
        itemSaleDetailMapper.updateBySaleId(id);
        return 0;
    }

    @Override
    public List<SearchItem> getAllItem(Date currentTime) {
        return itemSaleMapper.getAllItem(currentTime);
    }

    private StringBuffer reduceStock(ItemSaleDetail detail) {
        StringBuffer itemFrom = new StringBuffer();
        RepoRemain repoRemain = repoRemainMapper.selectByItemId(detail.getItemId());
        long num = detail.getSaleNumber();
        BigDecimal stock = repoRemain.getTotalRemain().subtract(new BigDecimal(detail.getSaleNumber()));
        repoRemain.setTotalRemain(stock);
        repoRemainMapper.updateByPrimaryKey(repoRemain);

        List<RepoRemainDetail> repoRemainDetailList = repoRemainDetailMapper.getRemainDetailByItem(repoRemain.getId());
        for (RepoRemainDetail repoRemainDetail : repoRemainDetailList) {
            itemFrom.append(repoRemainDetail.getSupplierId()).append("-")
                    .append(repoRemainDetail.getTimes()).append("-");
            if (num > repoRemainDetail.getRemainAmount()) {
                num = num - repoRemainDetail.getRemainAmount();
                itemFrom.append(repoRemainDetail.getRemainAmount()).append(",");
                repoRemainDetail.setRemainAmount(0);
            } else {
                repoRemainDetail.setRemainAmount((int) (repoRemainDetail.getRemainAmount() - num));
                itemFrom.append(num).append(",");
                repoRemainDetailMapper.updateByPrimaryKey(repoRemainDetail);
                break;
            }
            repoRemainDetailMapper.updateByPrimaryKeySelective(repoRemainDetail);
        }
        return itemFrom;
    }

    //在销售详情中加一个字段记录批次（2-5，3-7）
    private void addStock(ItemSaleDetail detail) {
        RepoRemain repoRemain = repoRemainMapper.selectByItemId(detail.getItemId());
        long num = detail.getSaleNumber();
        BigDecimal stock = repoRemain.getTotalRemain().add(new BigDecimal(detail.getSaleNumber()));
        repoRemain.setTotalRemain(stock);
//        总库存增加
        repoRemainMapper.updateByPrimaryKey(repoRemain);
//====================================模拟数据==================
        String s = detail.getBatch();
        String[] sArr = s.split(",");
//        分批次增加
        for (String ss : sArr) {
            String supp = ss.split("-")[0];
            String batch = ss.split("-")[1];
            String count = ss.split("-")[2];
//            System.out.println(batch + "$" + count);
            RepoRemainDetailKey repoRemainDetailKey = new RepoRemainDetailKey();
            repoRemainDetailKey.setRepoRemainId(repoRemain.getId());
            repoRemainDetailKey.setTimes(Integer.valueOf(batch));
            repoRemainDetailKey.setSupplierId(supp);

            RepoRemainDetail repoRemainDetail = repoRemainDetailMapper.selectByPrimaryKey(repoRemainDetailKey);
            repoRemainDetail.setRemainAmount(Integer.valueOf(count) + repoRemainDetail.getRemainAmount());

            repoRemainDetailMapper.updateByPrimaryKey(repoRemainDetail);
        }
//====================================模拟数据==================

//        for (RepoRemainDetail repoRemainDetail : repoRemainDetailList) {
//            if (num > repoRemainDetail.getRemainAmount()) {
//                num = num - repoRemainDetail.getRemainAmount();
//                repoRemainDetail.setRemainAmount(0);
//            } else {
//                repoRemainDetail.setRemainAmount((int) (repoRemainDetail.getRemainAmount() - num));
//                repoRemainDetailMapper.updateByPrimaryKey(repoRemainDetail);
//                break;
//            }
//            repoRemainDetailMapper.updateByPrimaryKey(repoRemainDetail);
//        }
    }

    //    用于创建测试数据
    @Transactional
    @Override
    public int createSaleOrderData(SaleSettlementReq saleSettlementReq) {
        Id idWorker = new Id(0, 0);
        ItemSale itemSale = saleSettlementReq.getItemSale();
        itemSale.setId(String.valueOf(idWorker.nextId()));
        itemSale.setSaleRejectRemark(1);

        if (itemSale.getMemberId() != null && !itemSale.getMemberId().equals("")) {
            Member member = memberMapper.selectByPrimaryKey(itemSale.getMemberId());
            BigDecimal money = member.getMemberAmountMoney().add(itemSale.getSaleTotalAmount());
            member.setMemberAmountMoney(money);
            memberMapper.updateByPrimaryKeySelective(member);
        }
        List<ItemSaleDetail> itemSaleDetails = saleSettlementReq.getItemSaleDetails();
        for (ItemSaleDetail detail : itemSaleDetails) {
            StringBuffer itemFrom = reduceStock(detail);
            detail.setItemSaleId(itemSale.getId());
            detail.setRepoId("1");
            detail.setSupplierId("1");
            detail.setSaleRejectRemark(1);
            detail.setSaleTime(itemSale.getSaleTime());
            detail.setBatch(itemFrom.toString());
        }
        itemSaleMapper.insert(itemSale);
        itemSaleDetailMapper.insertSaleDetail(itemSaleDetails);
        return 0;
    }
}
