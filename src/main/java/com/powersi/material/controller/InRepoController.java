package com.powersi.material.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.requestBody.InRepoReq;
import com.powersi.material.pojo.requestBody.InRepositoryDetailReq;
import com.powersi.material.pojo.requestBody.SelectInRepoReq;
import com.powersi.material.pojo.responseBody.InRepositoryDetailRes;
import com.powersi.material.pojo.responseBody.RemainDetailRes;
import com.powersi.material.pojo.responseBody.SelectInRepoRes;
import com.powersi.material.service.InRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("InRepo")
public class InRepoController {

    final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private InRepoService service;

    @PostMapping("/selectAllInRepo")
    public ResponseEntity<String> selectAllInRepo(@RequestBody SelectInRepoReq req) {
        try {
            //员工
            if ("".equals(req.getEmployeeId())){
                req.setEmployeeId(null);
            }
            //入库时间
            if(req.getInRepoDate()[0] == null){
                req.setInRepoDate(null);
            }
            //入库 或 收货 编号
            if("".equals(req.getId())){
                req.setId(null);
            }
            PageInfo<SelectInRepoRes> list = service.selectAllInRepo(req);
            return ResponseEntity.ok(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/selectInRepoDetail")
    public ResponseEntity<String> selectInRepoDetail(@RequestBody InRepositoryDetailReq req) {
        try {
            if ("".equals(req.getItemId())){
                req.setItemId(null);
            }
            if("".equals(req.getSupplierId())){
                req.setSupplierId(null);
            }
            if("".equals(req.getInRepoNumber1())){
                req.setInRepoNumber1(null);
            }
            if("".equals(req.getInRepoNumber2())){
                req.setInRepoNumber2(null);
            }
            if("".equals(req.getRepoId())){
                req.setRepoId(null);
            }

            System.out.println(JSON.toJSONString(req));

            PageInfo<InRepositoryDetailRes> list = service.selectInRepoDetail(req);

            return ResponseEntity.ok(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping("/addInRepositoryDetail")
    public ResponseEntity<String> addInRepositoryDetail(@RequestBody InRepoReq req) {

        try {

            boolean b = service.addInRepositoryDetail(req);

            return ResponseEntity.ok(mapper.writeValueAsString(b));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }


}


