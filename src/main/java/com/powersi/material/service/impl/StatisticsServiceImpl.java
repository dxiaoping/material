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
        List<RepoRemainDetail> repoRemainDetailList = repoRemainMapper
                .selectByTime(startTime, endTime, itemClass);
        List<TurnoverRes> turnoverResList = new ArrayList<>();
        if (itemSaleDetailList.size() == 0 || repoRemainDetailList.size() == 0) return turnoverResList;
//        计算销售额
//        如果销售记录为空
//        计算销售额和数量
        turnoverResList = this.parseTurnover(itemSaleDetailList, cycle);
//        计算成本
        turnoverResList = calculation(turnoverResList, repoRemainDetailList, cycle);
//        计算利润
        turnoverResList = calculation(turnoverResList);
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

    private List<TurnoverRes> parseTurnover(List<ItemSaleDetail> itemSaleDetailList, String cycle) {
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
            boolean isGotoNextSection = getDateName(itemSaleDetail.getSaleTime(), cycle).equals(turnoverResList.get(turnoverResList.size() - 1).getDateTime());
            if (isGotoNextSection) {
                saleVolume = saleVolume.add(itemSaleDetail.getSaleAfterDiscount());
                saleNum = saleNum + itemSaleDetail.getSaleNumber();
            } else {
//               结束上一区间计算并赋值， 进入下一区间，创建新对象
                turnoverRes.setSaleVolume(saleVolume);
                turnoverRes.setSaleNum(saleNum);
                turnoverRes.setCost(cost);
                turnoverRes.setProfit(profit);
                turnoverRes = new TurnoverRes();
//                turnoverRes.setDateTime(sdfYear.format(itemSaleDetail.getSaleTime()));
                turnoverRes.setDateTime(getDateName(itemSaleDetail.getSaleTime(), cycle));
                turnoverResList.add(turnoverRes);
                cost = new BigDecimal(0);
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

    private String getDateName(Date date, String cycle) {
        String dateName = "";
        String month = sdfMonth.format(date);
        ;
        String year = sdfYear.format(date);
        ;
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
                    dateName = year + "-一季度";
                } else if (Integer.valueOf(month) < 7) {
                    dateName = year + "-二季度";
                } else if (Integer.valueOf(month) < 10) {
                    dateName = year + "-三季度";
                } else {
                    dateName = year + "-四季度";
                }
                break;
            case Const.TURNOVER.MONTH:
                dateName = sdfYearMonth.format(date);
                break;
        }
        return dateName;
    }

    //        计算增长比 保留4位小数 向上取整
    private List<TurnoverRes> calculation(List<TurnoverRes> turnoverResList, List<RepoRemainDetail> repoRemainDetailList, String cycle) {

        BigDecimal costIncrease = new BigDecimal(0);
        BigDecimal profitIncrease = new BigDecimal(0);
        BigDecimal saleVolumeIncrease = new BigDecimal(0);
        BigDecimal saleNumIncrease = new BigDecimal(0);
        BigDecimal cost = new BigDecimal(0);
        int index = 0;//
        TurnoverRes turnoverRes1 = turnoverResList.get(0);
        turnoverRes1.setCostIncrease(costIncrease);
        turnoverRes1.setProfitIncrease(profitIncrease);
        turnoverRes1.setSaleVolumeIncrease(saleVolumeIncrease);
        turnoverRes1.setSaleNumIncrease(saleNumIncrease);
//        turnoverRes1.setSaleVolume(new BigDecimal(0));
//        turnoverRes1.setSaleNum(0l);
//        turnoverRes1.setCost(new BigDecimal(0));
//        turnoverRes1.setProfit(new BigDecimal(0));


        TurnoverRes turnoverRes2 = null;
//        如果在某个区间，进货存在数据，销售不存在，则添加一个turnoverRes
        int addedTurnoverResIndex = -1;
        while (index < repoRemainDetailList.size()) {
            RepoRemainDetail repoRemainDetail = repoRemainDetailList.get(index);
            if (turnoverRes1.getDateTime().equals(getDateName(repoRemainDetail.getInRepoDate(), cycle))) {
                cost = cost.add(repoRemainDetail.getRepoRemainInPic()
                        .multiply(new BigDecimal(repoRemainDetail.getRemainAmount())));
            } else if (!getDateName(repoRemainDetail.getInRepoDate(), cycle)
                    .equals(turnoverResList.get(addedTurnoverResIndex + 1).getDateTime())
                    && !getDateName(repoRemainDetail.getInRepoDate(), cycle)
                    .equals(turnoverResList.get(1).getDateTime())) {
//                2018 2019 2020 added = -1
//                    当进货从2018遍历到2019时应与2019比较，实际与2018比较，故多添加一个对象
//                2018 2019 2020  added = 0
//                当进货从2017遍历到2018时 与2018比较 实际与2018比较

//                    在销售额统计时不存在这一时间段，但这一时间段存在进货
                if (addedTurnoverResIndex > -1) {
                    turnoverResList.get(addedTurnoverResIndex).setCost(cost);
                }
                if (addedTurnoverResIndex > 0) {
                    if (turnoverResList.get(addedTurnoverResIndex - 1).getCost() != null && turnoverResList.get(addedTurnoverResIndex - 1).getCost().longValue() > 0) {
                        costIncrease = (turnoverResList.get(addedTurnoverResIndex).getCost().subtract(turnoverResList.get(addedTurnoverResIndex - 1).getCost()))
                                .divide(turnoverResList.get(addedTurnoverResIndex - 1).getCost(), 4, RoundingMode.HALF_UP);
                        turnoverResList.get(addedTurnoverResIndex).setCostIncrease(costIncrease);
                    }
                }
                TurnoverRes turnoverRes = new TurnoverRes();
                turnoverRes.setDateTime(getDateName(repoRemainDetail.getInRepoDate(), cycle));
                turnoverResList.add(++addedTurnoverResIndex, turnoverRes);
                if (addedTurnoverResIndex>0){
                    turnoverRes1.setCost(cost);
                    cost = new BigDecimal(0);
                }
                turnoverRes1 = turnoverResList.get(addedTurnoverResIndex);
                turnoverRes1.setCostIncrease(costIncrease);
                turnoverRes1.setProfitIncrease(profitIncrease);
                turnoverRes1.setSaleVolumeIncrease(saleVolumeIncrease);
                turnoverRes1.setSaleNumIncrease(saleNumIncrease);

                turnoverRes1.setSaleVolume(new BigDecimal(0));
                turnoverRes1.setSaleNum(0l);
                continue;
            } else {
                turnoverRes1.setCost(cost);
                if (addedTurnoverResIndex > 0) {
                    if (turnoverResList.get(addedTurnoverResIndex - 1).getCost() != null && turnoverResList.get(addedTurnoverResIndex - 1).getCost().longValue() > 0) {
                        costIncrease = (turnoverResList.get(addedTurnoverResIndex).getCost().subtract(turnoverResList.get(addedTurnoverResIndex - 1).getCost()))
                                .divide(turnoverResList.get(addedTurnoverResIndex - 1).getCost(), 4, RoundingMode.HALF_UP);
                        turnoverResList.get(addedTurnoverResIndex).setCostIncrease(costIncrease);
                    }
                }
                break;
            }
            index++;
        }

        for (int i = (addedTurnoverResIndex == -1 ? 1 : addedTurnoverResIndex + 1);
             i < turnoverResList.size(); i++) {
            cost = new BigDecimal(0);
            turnoverRes1 = turnoverResList.get(i - 1);
            turnoverRes2 = turnoverResList.get(i);
            turnoverRes2.setCost(new BigDecimal(0));
//            ===========================================
            while (index < repoRemainDetailList.size()) {
                RepoRemainDetail repoRemainDetail = repoRemainDetailList.get(index);
//                如果当前区间与进货时间对应，计算成本
                if (turnoverRes2.getDateTime().equals(getDateName(repoRemainDetail.getInRepoDate(), cycle))) {
                    cost = cost.add(repoRemainDetail.getRepoRemainInPic()
                            .multiply(new BigDecimal(repoRemainDetail.getRemainAmount())));
//                  如果当前进货数据与当前区间和后一个区间无法对应表示该区间缺失，需新增
                } else if (i + 1 < turnoverResList.size() && !getDateName(repoRemainDetail.getInRepoDate(), cycle).equals(turnoverResList.get(i + 1).getDateTime())) {
//                    在销售额统计时不存在这一时间段，但这一时间段存在进货
                    turnoverRes2.setCost(cost);
                    cost = new BigDecimal(0);
                    if (turnoverRes2.getSaleVolume() == null) {
                        turnoverRes2.setSaleVolume(new BigDecimal(0));
                    }
                    TurnoverRes turnoverRes = new TurnoverRes();
                    turnoverRes.setDateTime(getDateName(repoRemainDetail.getInRepoDate(), cycle));
                    turnoverResList.add(i + 1, turnoverRes);
                    break;
//                    与当前区间的后一个区间可以对应上，继续下一个区间
                } else {
                    turnoverRes2.setCost(cost);
                    if (turnoverRes2.getSaleVolume() == null) {
                        turnoverRes2.setSaleVolume(new BigDecimal(0));
                    }
                    break;
                }
                index++;
                if (index==repoRemainDetailList.size()){
                    turnoverRes2.setCost(cost);
                    turnoverRes2.setSaleVolume(new BigDecimal(0));
                }

            }
//            ===========================================
            if (turnoverRes1.getCost() != null && turnoverRes1.getCost().longValue() > 0) {
                costIncrease = (turnoverRes2.getCost().subtract(turnoverRes1.getCost()))
                        .divide(turnoverRes1.getCost(), 4, RoundingMode.HALF_UP);
            }
//            profitIncrease = (turnoverRes2.getProfit().subtract(turnoverRes1.getProfit()))
//            .divide(turnoverRes1.getProfit(), 4, RoundingMode.HALF_UP);
            if (turnoverRes1.getSaleVolume() != null && turnoverRes1.getSaleVolume().longValue() > 0) {
                saleVolumeIncrease = (turnoverRes2.getSaleVolume().subtract(turnoverRes1.getSaleVolume()))
                        .divide(turnoverRes1.getSaleVolume(), 4, RoundingMode.HALF_UP);
            }
            if (turnoverRes1.getSaleNum() > 0) {
                saleNumIncrease = new BigDecimal(turnoverRes2.getSaleNum() - turnoverRes1.getSaleNum())
                        .divide(new BigDecimal(turnoverRes1.getSaleNum()), 4, RoundingMode.HALF_UP);
            }
            turnoverRes2.setCostIncrease(costIncrease);
//            turnoverRes2.setProfitIncrease(profitIncrease);
            turnoverRes2.setSaleVolumeIncrease(saleVolumeIncrease);
            turnoverRes2.setSaleNumIncrease(saleNumIncrease);
        }
        return turnoverResList;
    }

    private List<TurnoverRes> calculation(List<TurnoverRes> turnoverResList) {
        for (TurnoverRes turnoverRes : turnoverResList) {
            System.out.println(turnoverRes);
            System.out.println(turnoverRes.getCost());
            System.out.println(turnoverRes.getSaleVolume());
            turnoverRes.setProfit(turnoverRes.getSaleVolume().subtract(turnoverRes.getCost()));
        }
        for (int i = 1; i < turnoverResList.size(); i++) {
            BigDecimal profitIncrease = new BigDecimal(0);
            if (turnoverResList.get(i - 1).getProfit() != null && turnoverResList.get(i - 1).getProfit().longValue() != 0) {
                BigDecimal difference = turnoverResList.get(i).getProfit().subtract(turnoverResList.get(i - 1).getProfit());
                profitIncrease = (difference).divide(turnoverResList.get(i - 1).getProfit(), 4, RoundingMode.HALF_UP);
                if (difference.longValue() > 0) {
                    profitIncrease = profitIncrease.abs();
                }
            }
            turnoverResList.get(i).setProfitIncrease(profitIncrease);
        }
        return turnoverResList;
    }
}
