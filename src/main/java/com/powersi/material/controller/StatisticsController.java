package com.powersi.material.controller;

import com.powersi.material.pojo.requestBody.BestsellerReq;
import com.powersi.material.pojo.requestBody.TurnoverReq;
import com.powersi.material.pojo.responseBody.BestsellerRes;
import com.powersi.material.pojo.responseBody.TurnoverRes;
import com.powersi.material.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 统计查询
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-24 13:50
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    IStatisticsService statisticsService;

    /**
     * 营业额统计
     * @param turnoverReq 起止时间;统计周期;商品类别
     * @return
     */
    @PostMapping("turnover")
    public ResponseEntity<List> getTurnoverList(@RequestBody(required = false) TurnoverReq turnoverReq){

        List<TurnoverRes> list = null;
        list = statisticsService.getTurnoverStatistics(turnoverReq);

        return ResponseEntity.ok(list);
    }

    /**
     * 获取畅销榜
     * @param bestsellerReq
     * @return
     */
    @PostMapping("bestseller")
    public ResponseEntity<List> getBestsellerList(@RequestBody(required = false) BestsellerReq bestsellerReq){

        List<BestsellerRes> list = null;
        list = statisticsService.getBestsellerList(bestsellerReq);

        return ResponseEntity.ok(list);
    }
}
