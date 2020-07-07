package com.powersi.material.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.commons.Id;
import com.powersi.material.mapper.*;
import com.powersi.material.pojo.InRepository;
import com.powersi.material.pojo.InRepositoryDetail;
import com.powersi.material.pojo.RepoRemain;
import com.powersi.material.pojo.RepoRemainDetail;
import com.powersi.material.pojo.requestBody.InRepoListReq;
import com.powersi.material.pojo.requestBody.InRepoReq;
import com.powersi.material.pojo.requestBody.InRepositoryDetailReq;
import com.powersi.material.pojo.requestBody.SelectInRepoReq;
import com.powersi.material.pojo.responseBody.InRepositoryDetailRes;
import com.powersi.material.pojo.responseBody.SelectInRepoRes;
import com.powersi.material.service.InRepoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class InRepoServiceImpl implements InRepoService {

    @Autowired
    private InRepositoryMapper mapper;
    @Autowired
    private InRepositoryDetailMapper idmapper;
    @Autowired
    private ReceiveDetailMapper rdmapper;
    @Autowired
    private RepoRemainDetailMapper rrdmapper;

    @Autowired
    private RepoRemainMapper rrmapper;
    @Autowired
    private Id id;


    public PageInfo<SelectInRepoRes> selectAllInRepo(SelectInRepoReq req){

        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        PageInfo<SelectInRepoRes> info = new PageInfo<>(mapper.selectAllInRepo(req));

        return info;

    }


    public PageInfo<InRepositoryDetailRes> selectInRepoDetail(InRepositoryDetailReq req) {

        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        List<InRepositoryDetailRes> list = null;

        if (req.getInRepoState() == 0){
            //未入库，在收货详情查询
            list = rdmapper.selectInRepoDetail(req);
        }else if (req.getInRepoState() == 1){
            //已入库，在入库详情查询
            list = idmapper.selectInRepoDetail(req);
        }

        PageInfo<InRepositoryDetailRes> info = new PageInfo<>(list);

        return info;

    }

    @Transactional
    public boolean addInRepositoryDetail(InRepoReq req){

        //时间
        Date date = new Date();
        //库存详情集合
        InRepoListReq[] ilqs = req.getIlq();
        //入库编号
        String inRepoId = ilqs[0].getInRepoId();


        //修改入库
        int u = mapper.updateInRepo(req.getEmployeeId(),date,inRepoId);


        for (int i = 0 ; i < ilqs.length ; i++){

            //添加入库详情
            InRepoListReq ilq = ilqs[i];

            InRepositoryDetail ird = new InRepositoryDetail();

            Integer times = rrdmapper.getTimesByItemId(ilq.getItemId());

            if(times != null){
                times = times + 1;
            }else{
                times = 1;
            }

            ird.setRepoId(ilq.getRepoId());
            ird.setItemId(ilq.getItemId());
            ird.setSupplierId(ilq.getSupplierId());
            ird.setInRepoId(ilq.getInRepoId());
            ird.setTimes(times);
            ird.setInRepoNumber(ilq.getInRepoNumber());

            idmapper.insert(ird);

            //判断有无库存
            RepoRemain rr = rrdmapper.selectByItemId(ilq.getItemId());
            if (rr != null){

                rr.setTotalRemain(rr.getTotalRemain().add(ilq.getInRepoNumber()));

                rrmapper.updateByPrimaryKey(rr);

            }else {

                 rr = new RepoRemain();

                rr.setId(id.nextId()+"");
                rr.setRepoId(ilq.getRepoId());
                rr.setItemId(ilq.getItemId());
                rr.setTotalRemain(ilq.getInRepoNumber());

                rrmapper.insert(rr);

            }

            //插入库存详情
            RepoRemainDetail rrd = new RepoRemainDetail();

            rrd.setRepoRemainId(rr.getId());
            rrd.setSupplierId(ilq.getSupplierId());
            rrd.setTimes(times);

            String str=ilq.getInRepoNumber().toString();
            Integer integer=Integer.parseInt(str);
            rrd.setRemainAmount(integer);
            System.out.println(ilq.getItemLatelyPic());
            rrd.setRepoRemainInPic(ilq.getItemLatelyPic());
            rrd.setInRepoDate(date);

            rrdmapper.insert(rrd);



        }

        return true;

    }

    @Override
    public void insertInRepository(InRepository inRepository) {
        mapper.insert(inRepository);
    }

}
