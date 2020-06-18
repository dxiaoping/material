package com.powersi.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powersi.material.pojo.Item;
import com.powersi.material.pojo.requestBody.ItemListParam;
import com.powersi.material.service.ItemService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service = null;

    final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/searchItem")
    public ResponseEntity<String> searchItem (Integer pageNO,ItemListParam item){

        if (item == null) return ResponseEntity.badRequest().body("错误的请求");

        System.out.println(item.getItemClass());
        System.out.println(item.getItemName());
        System.out.println(pageNO);

        try {

            System.out.println(mapper.writeValueAsString(service.searchItem(pageNO,item.getItemName(),item.getItemClass())));

            return ResponseEntity.ok(mapper.writeValueAsString(service.searchItem(pageNO,item.getItemName(),item.getItemClass())));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }

}