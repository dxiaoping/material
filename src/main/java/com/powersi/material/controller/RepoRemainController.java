package com.powersi.material.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.requestBody.SeLectItemDTO;
import com.powersi.material.pojo.responseBody.ClassRemainRes;
import com.powersi.material.pojo.responseBody.RepoRemainRes;
import com.powersi.material.pojo.responseBody.SelectItemRes;
import com.powersi.material.service.RepoRemainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repoRemain")
@Slf4j
public class RepoRemainController {

    final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RepoRemainService service;

    @GetMapping("/selectAllRemain")
    public ResponseEntity<String> selectAllRemain( RepoRemainReq repo,
                                                   Integer pageNO,
                                                   Integer pageSize) {

        System.out.println(pageNO);
        System.out.println(pageSize);
        System.out.println(JSON.toJSONString(repo));

        try {

            if ("".equals(repo.getItemName())){
                repo.setItemName(null);
            }
            if ("".equals(repo.getItemFactoryName())){
                repo.setItemFactoryName(null);
            }
            if ("".equals(repo.getTotalRemain())){
                repo.setTotalRemain(null);
            }

            System.out.println(JSON.toJSONString(repo));

            PageInfo<RepoRemainRes> list = service.selectAllRemain(repo,pageNO,pageSize);


            

            return ResponseEntity.ok(mapper.writeValueAsString(list));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }


    @GetMapping("/getClassRemain")
    public ResponseEntity<String> getClassRemain(Integer classId) {

        try {
            System.out.println("类别："+classId);
            List<ClassRemainRes> list = service.getClassRemain(classId);

            return ResponseEntity.ok(mapper.writeValueAsString(list));

        } catch (JsonProcessingException e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

    }
    }


}
