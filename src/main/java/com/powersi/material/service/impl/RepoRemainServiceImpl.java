package com.powersi.material.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.mapper.RepoRemainDetailMapper;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.responseBody.RepoRemainRes;
import com.powersi.material.service.RepoRemainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
    @Slf4j
    public class RepoRemainServiceImpl implements RepoRemainService {

        @Autowired
        RepoRemainDetailMapper rrdmapper;

    /**
     * 查询库存情况
     * @param req
     * @return
     */
    @Override
    @Transactional
    public PageInfo<RepoRemainRes> selectAllRemain(RepoRemainReq req,Integer pageNO,Integer pageSize) {

        PageHelper.startPage(pageNO,pageSize);

        List<RepoRemainRes> list = rrdmapper.selectAllRemain(req);

        PageInfo<RepoRemainRes> info = new PageInfo<>(list);

        return info;
    }
}
