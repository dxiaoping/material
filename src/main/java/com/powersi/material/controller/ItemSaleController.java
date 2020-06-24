package com.powersi.material.controller;
/**
 * @description: 销售单管理
 * @author: Duan xiaoping
 * @mailbox: xiaoping.duan@powersi.com.cn
 * @create: 2020-06-9 10:34
 */
import com.powersi.material.pojo.ItemSaleDetail;
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

//    @PostMapping
//    public ResponseEntity<Integer> createSaleOrder(@RequestBody List<ItemSaleDetail> list){
//        int count = itemSaleService.createSaleOrder(list);
//        return ResponseEntity.ok(count);
//    }

    @PostMapping("sale_list")
    public ResponseEntity<List> getSaleList(@RequestBody(required = false) SaleListReq saleListReq){

        List list = itemSaleService.getSaleList(saleListReq);

        return ResponseEntity.ok(list);
    }

    @GetMapping("detail")
    public ResponseEntity<List> detail(String itemSaleId){

        List list = itemSaleService.getSaleDetail(itemSaleId);
        return ResponseEntity.ok(list);
    }
    @PostMapping("settlement")
    public ResponseEntity<String> settlement(@RequestBody SaleSettlementReq saleSettlementReq){
          //                          /*销售编号*/
          //                          /*顾客编号*/
          //                          /*操作人员编号*/
          //                          /*销售时间*/
          //                          /*退货标记*/
          //                          /*总金额*/
          //                          /*优惠金额*/
          //                          /*折后价*/
        itemSaleService.createSaleOrder(saleSettlementReq);
        return ResponseEntity.ok("");
    }
}
