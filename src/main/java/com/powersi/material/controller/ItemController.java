package com.powersi.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.commons.Id;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.ItemClass;
import com.powersi.material.pojo.requestBody.ItemListParam;
import com.powersi.material.pojo.requestBody.SeLectItemDTO;
import com.powersi.material.pojo.responseBody.SelectItemRes;
import com.powersi.material.service.impl.ItemService;
import com.powersi.material.units.BarcodeUtil;
import com.powersi.material.units.PingYinUtils;
import com.powersi.material.units.PinyinToWubi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service = null;

    final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody(required = false) Item item) {

        if (item == null) return ResponseEntity.badRequest().body("商品信息未补全");

        try {

            if (item != null){

                Item i = service.addItem(item);

                if("".equals(i.getId())){
                    return ResponseEntity.ok("-1");
                }

                return ResponseEntity.ok(mapper.writeValueAsString(i));
            }else{
                return ResponseEntity.badRequest().body("添加商品出错误");
            }

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }


    @GetMapping("/searchItem")
    public ResponseEntity<String> searchItem (Integer pageNO,ItemListParam item){

        if (item == null) return ResponseEntity.badRequest().body("错误的请求");

        System.out.println(item.getItemClass());
        System.out.println(item.getItemName());
        System.out.println(pageNO);

        try {

            return ResponseEntity.ok(mapper.writeValueAsString(service.searchItem(pageNO,item.getItemName(),item.getItemClass())));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }


    @RequestMapping("/getItemClass")
    public ResponseEntity<String> getItemClass() {

        try {

            List<ItemClass> list = service.getItemClass();
            return ResponseEntity.ok(mapper.writeValueAsString(list));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }

    @GetMapping("/selectItem")
    public ResponseEntity<String> selectItem(SeLectItemDTO Iteminfo,Integer pageNO,Integer pageSize) {

        try {

            if ("".equals(Iteminfo.getItemName())){
                Iteminfo.setItemName(null);
            }
            if ("".equals(Iteminfo.getItemFactoryName())){
                Iteminfo.setItemFactoryName(null);
            }

            PageInfo<SelectItemRes> list= service.selectItem(Iteminfo,pageNO,pageSize);

            return ResponseEntity.ok(mapper.writeValueAsString(list));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }
    @GetMapping("/search")
    public ResponseEntity<String> search (String keyWord){
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(service.search(keyWord)));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/updateItem")
    public ResponseEntity<String> updateItem(@RequestBody(required = false) Item item) {

        if (item == null) return ResponseEntity.badRequest().body("商品信息未补全");

        try {

            if (item != null){
                return ResponseEntity.ok(mapper.writeValueAsString(service.updateItem(item)));
            }else{
                return ResponseEntity.badRequest().body("修改商品出错误");
            }

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }


    @PostMapping("/deleteItem")
    public ResponseEntity<String> deleteItem(String itemid) {

        if (itemid == null) return ResponseEntity.badRequest().body("删除商品失败");

        try {

                return ResponseEntity.ok(mapper.writeValueAsString(service.deleteItem(itemid)));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }


    @PostMapping("/searchItemById")
    public ResponseEntity<String> searchItemById(String id) {

        try {

            Item item = service.searchItemById(id);

            return ResponseEntity.ok(mapper.writeValueAsString(item));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }

}
