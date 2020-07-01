package com.powersi.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.requestBody.SeLectItemDTO;
import com.powersi.material.pojo.responseBody.SelectItemRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("repoRemain")
public class RepoRemainController {

    final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/selectAllRemain")
    public ResponseEntity<String> selectItem() {

        try {

//            if ("".equals(Iteminfo.getItemFactoryName())){
//                Iteminfo.setItemFactoryName(null);
//            }


            return ResponseEntity.ok(mapper.writeValueAsString(null));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }



}
