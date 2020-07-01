package com.powersi.material.service;

import com.powersi.material.pojo.requestBody.BestsellerReq;
import com.powersi.material.pojo.requestBody.TurnoverReq;
import com.powersi.material.pojo.responseBody.BestsellerRes;
import com.powersi.material.pojo.responseBody.TurnoverRes;

import java.util.List;

public interface IStatisticsService {
    List<TurnoverRes> getTurnoverStatistics(TurnoverReq turnoverReq);
    List<BestsellerRes> getBestsellerList(BestsellerReq bestsellerReq);
}
