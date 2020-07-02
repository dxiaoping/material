package com.powersi.material.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.requestBody.RemainDetailReq;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.requestBody.SeLectItemDTO;
import com.powersi.material.pojo.responseBody.*;
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

    @PostMapping("/selectRemainDetail")
    public ResponseEntity<String> selectRemainDetail(@RequestBody RemainDetailReq rd) {

        try {

            if ("".equals(rd.getTotalRemain())){
                rd.setTotalRemain(null);
            }
            if(rd.getInRepoDate()[0] == null){
                rd.setInRepoDate(null);
            }
            if("".equals(rd.getSupplierId())){
                rd.setSupplierId(null);
            }

            System.out.println(JSON.toJSONString(rd));

            PageInfo<RemainDetailRes> list = service.selectRemainDetail(rd);

            return ResponseEntity.ok(mapper.writeValueAsString(list));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }

    }

    @GetMapping("getTimesAndSup")
    public ResponseEntity<String> getTimesAndSup(String id){

        try {

            RemainDetailTimesSupRes rdts = service.getTimesAndSup(id);

            return ResponseEntity.ok(mapper.writeValueAsString(rdts));

        } catch (JsonProcessingException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/selectAllRemain")
    public ResponseEntity<String> selectAllRemain( RepoRemainReq repo,
                                                   Integer pageNO,
                                                   Integer pageSize) {

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
