package com.powersi.material.service.impl;

import com.powersi.material.commons.Const;
import com.powersi.material.mapper.ItemClassMapper;
import com.powersi.material.mapper.ItemSaleDetailMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemClass;
import com.powersi.material.pojo.ItemSaleDetail;
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

    @Override
    public List<TurnoverRes> getTurnoverStatistics(TurnoverReq turnoverReq) {
        Date startTime = turnoverReq.getStartTime();
        Date endTime = turnoverReq.getEndTime();
        String cycle = turnoverReq.getCycle();
        String itemClass = turnoverReq.getItemClass();
//        获取销售详情
        List<ItemSaleDetail> itemSaleDetailList = itemSaleDetailMapper
                .selectByTimeAndClass(startTime, endTime, itemClass);
        List<TurnoverRes> turnoverResList = null;
        turnoverResList = this.parseTurnover(itemSaleDetailList, cycle);
        turnoverResList = calculation(turnoverResList);
        return turnoverResList;
    }

    @Override
    public List<BestsellerRes> getBestsellerList(BestsellerReq bestsellerReq) {
        List<BestsellerRes> bestsellerResList = itemSaleDetailMapper.selectBestsellerItem(bestsellerReq.getStartTime(), bestsellerReq.getEndTime());


        for (BestsellerRes bestsellerRes : bestsellerResList) {
            Item item = itemService.searchItemById(bestsellerRes.getItemId());
            ItemClass itemClass = itemClassMapper.selectByPrimaryKey(item.getItemClassId());
            bestsellerRes.setItemName(item.getItemName());
            bestsellerRes.setItemClassName(itemClass.getItemClassName());
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

//            costIncrease = (turnoverRes2.getCost().subtract(turnoverRes1.getCost()))
//            .divide(turnoverRes1.getCost(), 4, RoundingMode.HALF_UP);
//            profitIncrease = (turnoverRes2.getProfit().subtract(turnoverRes1.getProfit()))
//            .divide(turnoverRes1.getProfit(), 4, RoundingMode.HALF_UP);
            saleVolumeIncrease = (turnoverRes2.getSaleVolume().subtract(turnoverRes1.getSaleVolume()))
                    .divide(turnoverRes1.getSaleVolume(), 4, RoundingMode.HALF_UP);
            saleNumIncrease = new BigDecimal(turnoverRes2.getSaleNum() - turnoverRes1.getSaleNum())
                    .divide(new BigDecimal(turnoverRes1.getSaleNum()), 4, RoundingMode.HALF_UP);

//            turnoverRes2.setCostIncrease(costIncrease);
//            turnoverRes2.setProfitIncrease(profitIncrease);
            turnoverRes2.setSaleVolumeIncrease(saleVolumeIncrease);
            turnoverRes2.setSaleNumIncrease(saleNumIncrease);
        }
        return turnoverResList;
    }
}
