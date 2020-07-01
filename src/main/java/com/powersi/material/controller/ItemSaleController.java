package com.powersi.material.controller;
/**
 * @description: 销售单管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-9 10:34
 */

import com.powersi.material.pojo.requestBody.SaleListReq;
import com.powersi.material.pojo.requestBody.SaleSettlementReq;
import com.powersi.material.service.IItemSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item_sale")
public class ItemSaleController {

    @Autowired
    IItemSaleService itemSaleService;

    /**
     * 获取销售单列表
     *
     * @param saleListReq
     * @return
     */

    @PostMapping("sale_list")
    public ResponseEntity<List> getSaleList(@RequestBody(required = false) SaleListReq saleListReq) {

        List list = itemSaleService.getSaleList(saleListReq);

        return ResponseEntity.ok(list);
    }

    /**
     * 获取销售单详情
     *
     * @param itemSaleId
     * @return
     */
    @GetMapping("detail")
    public ResponseEntity<List> detail(String itemSaleId) {

        List list = itemSaleService.getSaleDetail(itemSaleId);
        return ResponseEntity.ok(list);
    }

    /**
     * 结算创建销售单及明细
     *
     * @param saleSettlementReq
     * @return
     */
    @PostMapping("settlement")
    public ResponseEntity<String> settlement(@RequestBody SaleSettlementReq saleSettlementReq) {

        itemSaleService.createSaleOrder(saleSettlementReq);
        return ResponseEntity.ok("");
    }

    /**
     * 退货
     *
     * @param id
     * @return
     */
    @PostMapping("back_sale")
    public ResponseEntity<String> delSale(String id) {
        itemSaleService.backSale(id);
        return ResponseEntity.ok("");
    }
}
