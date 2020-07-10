package com.powersi.material.service;

import com.powersi.material.pojo.requestBody.BestsellerReq;
import com.powersi.material.pojo.requestBody.TurnoverReq;
import com.powersi.material.pojo.responseBody.BestsellerRes;
import com.powersi.material.pojo.responseBody.TurnoverRes;

import java.util.List;

public interface IStatisticsService {
    /**
     * 获取营业额统计数据
     * @param turnoverReq
     * @return
     */
    List<TurnoverRes> getTurnoverStatistics(TurnoverReq turnoverReq);

    /**
     * 获取畅销榜统计
     * @param bestsellerReq
     * @return
     */
    List<BestsellerRes> getBestsellerList(BestsellerReq bestsellerReq);
}
