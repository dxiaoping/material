package com.powersi.material.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.mapper.InRepositoryMapper;
import com.powersi.material.pojo.requestBody.SelectInRepoReq;
import com.powersi.material.pojo.responseBody.SelectInRepoRes;
import com.powersi.material.service.InRepoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InRepoServiceImpl implements InRepoService {

    @Autowired
    private InRepositoryMapper mapper;

    public PageInfo<SelectInRepoRes> selectAllInRepo(SelectInRepoReq req){

        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        PageInfo<SelectInRepoRes> info = new PageInfo<>(mapper.selectAllInRepo(req));

        return info;

    }

}
