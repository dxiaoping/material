package com.powersi.material.service.impl;

import com.powersi.material.commons.Const;
import com.powersi.material.mapper.ItemClassMapper;
import com.powersi.material.mapper.ItemSaleDetailMapper;
import com.powersi.material.mapper.RepoRemainMapper;
import com.powersi.material.pojo.*;
import com.powersi.material.pojo.requestBody.BestsellerReq;
import com.powersi.material.pojo.requestBody.TurnoverReq;
import com.powersi.material.pojo.responseBody.BestsellerRes;
import com.powersi.material.pojo.responseBody.TurnoverRes;
import com.powersi.material.pojo.responseBody.WarehouseInfo;
import com.powersi.material.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 统计模块服务类
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-24 15:51
 */
@Service
public class StatisticsServiceImpl implements IStatisticsService {


    @Autowired
    ItemSaleDetailMapper itemSaleDetailMapper;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemClassMapper itemClassMapper;
    @Autowired
    RepoRemainMapper repoRemainMapper;

    @Override
    public List<TurnoverRes> getTurnoverStatistics(TurnoverReq turnoverReq) {
        Date startTime = turnoverReq.getStartTime();
        Date endTime = turnoverReq.getEndTime();
        String cycle = turnoverReq.getCycle();
        List<Integer> itemClass = turnoverReq.getItemClass();
//        类别筛选
        if (itemClass.size() == 0) {
            itemClass = itemClassMapper.selectClassId(null);
        } else {
            itemClass = itemClassMapper.selectClassId(itemClass.get(itemClass.size() - 1));
        }
//        获取销售详情 以计算销售额/销售数量
        List<ItemSaleDetail> itemSaleDetailList = itemSaleDetailMapper
                .selectByTimeAndClass(startTime, endTime, itemClass);
//        获取进货批次详情 以计算进货成本
        List<WarehouseInfo> warehouseInfoList = repoRemainMapper
                .selectByTime(startTime, endTime, itemClass);
        List<TurnoverRes> turnoverResList1 = new ArrayList<>();
        List<TurnoverRes> turnoverResList2 = new ArrayList<>();
//        计算销售额和数量
        if (itemSaleDetailList.size() > 0) {
            turnoverResList1 = this.parseTurnover1(itemSaleDetailList, cycle);
        }
//        计算成本
        if (warehouseInfoList.size() > 0) {
            turnoverResList2 = this.parseTurnover2(warehouseInfoList, cycle);
        }

        List<TurnoverRes> turnoverResList = merge(turnoverResList1, turnoverResList2);
//        增长比
        if (turnoverResList.size() > 0) {
            turnoverResList = calculation(turnoverResList);
        }
        return turnoverResList;
    }

    @Override
    public List<BestsellerRes> getBestsellerList(BestsellerReq bestsellerReq) {
        List<BestsellerRes> bestsellerResList = itemSaleDetailMapper.selectBestsellerItem(bestsellerReq.getStartTime(), bestsellerReq.getEndTime());
        for (BestsellerRes bestsellerRes : bestsellerResList) {
            Item item = itemService.searchItemById(bestsellerRes.getItemId());
            if (item == null) {
                System.out.print(bestsellerRes.getItemId());
                System.out.println("-商品在商品表已经被删除");
                continue;
            }
            ItemClass itemClass = itemClassMapper.selectByPrimaryKey(item.getItemClassId());
            RepoRemain repoRemain = repoRemainMapper.selectByItemId(item.getId());
            BigDecimal stockNum = (repoRemain == null) ? new BigDecimal(0) : repoRemain.getTotalRemain();
            bestsellerRes.setItemName(item.getItemName());
            bestsellerRes.setItemClassName(itemClass.getItemClassName());
            bestsellerRes.setStock(stockNum);
        }
        return bestsellerResList;
    }

    SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    SimpleDateFormat sdfYearMonth = new SimpleDateFormat("yyyy-MM");
    SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

    private List<TurnoverRes> parseTurnover1(List<ItemSaleDetail> itemSaleDetailList, String cycle) {
        List<TurnoverRes> turnoverResList = new ArrayList<>();
        int count = 0;
        TurnoverRes turnoverRes = new TurnoverRes();
        turnoverRes.setDateTime(getDateName(itemSaleDetailList.get(0).getSaleTime(), cycle));
        turnoverResList.add(turnoverRes);

        BigDecimal cost = new BigDecimal(0);     /**成本*/
        BigDecimal saleVolume = new BigDecimal(0);/**销售额*/
        long saleNum = 0l;/**销售数量*/
        BigDecimal profit = new BigDecimal(0);/**总利润*/

        for (ItemSaleDetail itemSaleDetail : itemSaleDetailList) {
//            判断当前销售数据时间是否在最后一个区间
            boolean isInSection = getDateName(itemSaleDetail.getSaleTime(), cycle).equals(turnoverResList.get(turnoverResList.size() - 1).getDateTime());
            if (isInSection) {
                saleVolume = saleVolume.add(itemSaleDetail.getSaleAfterDiscount());
                saleNum = saleNum + itemSaleDetail.getSaleNumber();
            } else {
//               结束上一区间计算并赋值， 进入下一区间，创建新对象
                turnoverRes.setSaleVolume(saleVolume);
                turnoverRes.setSaleNum(saleNum);
                turnoverRes.setCost(cost);
                turnoverRes.setProfit(profit);
                turnoverRes = new TurnoverRes();
                turnoverRes.setDateTime(getDateName(itemSaleDetail.getSaleTime(), cycle));
                turnoverResList.add(turnoverRes);
                cost = new BigDecimal(0);
                saleVolume = itemSaleDetail.getSaleAfterDiscount();
                saleNum = itemSaleDetail.getSaleNumber();
                profit = new BigDecimal(0);
            }
        }
//        对最后一区间赋值
        turnoverRes.setSaleVolume(saleVolume);
        turnoverRes.setSaleNum(saleNum);
        turnoverRes.setCost(cost);
        turnoverRes.setProfit(profit);
        return turnoverResList;
    }

    //部分成本为零的原因（目前使用错误数据源，销售后可能造成数量为0）
    private List<TurnoverRes> parseTurnover2(List<WarehouseInfo> warehouseInfoList, String cycle) {
        List<TurnoverRes> turnoverResList = new ArrayList<>();
        int count = 0;
        TurnoverRes turnoverRes = new TurnoverRes();
        turnoverRes.setDateTime(getDateName(warehouseInfoList.get(0).getInRepoDate(), cycle));
        turnoverResList.add(turnoverRes);

        BigDecimal cost = new BigDecimal(0);     /**成本*/
        BigDecimal saleVolume = new BigDecimal(0);/**销售额*/
        long saleNum = 0l;/**销售数量*/
        BigDecimal profit = new BigDecimal(0);/**总利润*/

        for (WarehouseInfo warehouseInfo : warehouseInfoList) {
//            判断当前销售数据时间是否在最后一个区间
            boolean isInSection = getDateName(warehouseInfo.getInRepoDate(), cycle).equals(turnoverResList.get(turnoverResList.size() - 1).getDateTime());
            if (isInSection) {
//                BigDecimal costMoney = warehouseInfo.getRepoRemainInPic().multiply(warehouseInfo.getNum());
                BigDecimal costMoney = warehouseInfo.getRepoRemainInPic().multiply(new BigDecimal(warehouseInfo.getRemainAmount()));
                cost = cost.add(costMoney);
            } else {
//               结束上一区间计算并赋值， 进入下一区间，创建新对象
                turnoverRes.setSaleVolume(saleVolume);
                turnoverRes.setSaleNum(saleNum);
                turnoverRes.setCost(cost);
                turnoverRes.setProfit(profit);
                turnoverRes = new TurnoverRes();
                turnoverRes.setDateTime(getDateName(warehouseInfo.getInRepoDate(), cycle));
                turnoverResList.add(turnoverRes);
                BigDecimal costMoney = warehouseInfo.getRepoRemainInPic().multiply(new BigDecimal(warehouseInfo.getRemainAmount()));
//                BigDecimal costMoney = warehouseInfo.getRepoRemainInPic().multiply(warehouseInfo.getNum());
                cost = cost.add(costMoney);
                saleVolume = new BigDecimal(0);
                saleNum = 0l;
                profit = new BigDecimal(0);
            }
        }
//        对最后一区间赋值
        turnoverRes.setSaleVolume(saleVolume);
        turnoverRes.setSaleNum(saleNum);
        turnoverRes.setCost(cost);
        turnoverRes.setProfit(profit);
        return turnoverResList;
    }

    private List<TurnoverRes> merge(List<TurnoverRes> saleVolumeList, List<TurnoverRes> costList) {
        int volumeIndex = 0;
        int costIndex = 0;
        int volumeListSize = saleVolumeList.size();
        int costListSize = costList.size();
        List<TurnoverRes> turnoverResList = new ArrayList<>();
        while (volumeIndex < volumeListSize && costIndex < costListSize) {
            TurnoverRes volumeTur = saleVolumeList.get(volumeIndex);
            TurnoverRes costTur = costList.get(costIndex);
            if (volumeTur.getDateTime().compareTo(costTur.getDateTime()) < 0) {
                turnoverResList.add(volumeTur);
                volumeIndex++;
            } else if (volumeTur.getDateTime().compareTo(costTur.getDateTime()) == 0) {
                volumeTur.setCost(costTur.getCost());
                turnoverResList.add(volumeTur);
                volumeIndex++;
                costIndex++;
            } else {
                turnoverResList.add(costTur);
                costIndex++;
            }
        }
        while (volumeIndex < volumeListSize) {
            turnoverResList.add(saleVolumeList.get(volumeIndex));
            volumeIndex++;
        }
        while (costIndex < costListSize) {
            turnoverResList.add(costList.get(costIndex));
            costIndex++;
        }
        for (TurnoverRes tur : turnoverResList) {
            tur.setProfit(tur.getSaleVolume().subtract(tur.getCost()));
        }
        return turnoverResList;
    }

    private String getDateName(Date date, String cycle) {
        String dateName = "";
        String month = sdfMonth.format(date);
        String year = sdfYear.format(date);
        switch (cycle) {
            case Const.TURNOVER.YEAR:
                dateName = year;
                break;
            case Const.TURNOVER.HALF_YEAR:
                if (Integer.valueOf(month) > 6) {
                    dateName = year + "-下半年";
                } else {
                    dateName = year + "-上半年";
                }
                break;
            case Const.TURNOVER.QUARTER:
                if (Integer.valueOf(month) < 4) {
                    dateName = year + "-1季度";
                } else if (Integer.valueOf(month) < 7) {
                    dateName = year + "-2季度";
                } else if (Integer.valueOf(month) < 10) {
                    dateName = year + "-3季度";
                } else {
                    dateName = year + "-4季度";
                }
                break;
            case Const.TURNOVER.MONTH:
                dateName = sdfYearMonth.format(date);
                break;
        }
        return dateName;
    }

    //        计算增长比 保留4位小数 向上取整
    private List<TurnoverRes> calculation(List<TurnoverRes> turnoverResList) {
        BigDecimal costIncrease = new BigDecimal(0);
        BigDecimal profitIncrease = new BigDecimal(0);
        BigDecimal saleVolumeIncrease = new BigDecimal(0);
        BigDecimal saleNumIncrease = new BigDecimal(0);
        TurnoverRes turnoverRes1 = turnoverResList.get(0);
        turnoverRes1.setCostIncrease(costIncrease);
        turnoverRes1.setProfitIncrease(profitIncrease);
        turnoverRes1.setSaleVolumeIncrease(saleVolumeIncrease);
        turnoverRes1.setSaleNumIncrease(saleNumIncrease);

        TurnoverRes turnoverRes2 = null;
        for (int i = 1; i < turnoverResList.size(); i++) {
            turnoverRes1 = turnoverResList.get(i - 1);
            turnoverRes2 = turnoverResList.get(i);
//            ===========================================
            if (turnoverRes1.getCost() != null && turnoverRes1.getCost().longValue() > 0) {
                costIncrease = (turnoverRes2.getCost().subtract(turnoverRes1.getCost()))
                        .divide(turnoverRes1.getCost(), 4, RoundingMode.HALF_UP);
            }
            if (turnoverRes1.getProfit() != null && turnoverRes1.getProfit().longValue() > 0) {
                profitIncrease = (turnoverRes2.getProfit().subtract(turnoverRes1.getProfit()))
                        .divide(turnoverRes1.getProfit(), 4, RoundingMode.HALF_UP);
            }
            if (turnoverRes1.getSaleVolume() != null && turnoverRes1.getSaleVolume().longValue() > 0) {
                saleVolumeIncrease = (turnoverRes2.getSaleVolume().subtract(turnoverRes1.getSaleVolume()))
                        .divide(turnoverRes1.getSaleVolume(), 4, RoundingMode.HALF_UP);
            }
            if (turnoverRes1.getSaleNum() > 0) {
                saleNumIncrease = new BigDecimal(turnoverRes2.getSaleNum() - turnoverRes1.getSaleNum())
                        .divide(new BigDecimal(turnoverRes1.getSaleNum()), 4, RoundingMode.HALF_UP);
            }
            turnoverRes2.setCostIncrease(costIncrease);
            turnoverRes2.setProfitIncrease(profitIncrease);
            turnoverRes2.setSaleVolumeIncrease(saleVolumeIncrease);
            turnoverRes2.setSaleNumIncrease(saleNumIncrease);
        }
        return turnoverResList;
    }
}
