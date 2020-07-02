package com.powersi.material.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powersi.material.mapper.RepoRemainDetailMapper;
import com.powersi.material.mapper.RepoRemainMapper;
import com.powersi.material.pojo.requestBody.RemainDetailReq;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.responseBody.ClassRemainRes;
import com.powersi.material.pojo.responseBody.RemainDetailRes;
import com.powersi.material.pojo.responseBody.RemainDetailTimesSupRes;
import com.powersi.material.pojo.responseBody.RepoRemainRes;
import com.powersi.material.service.RepoRemainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
    @Slf4j
    public class RepoRemainServiceImpl implements RepoRemainService {

        @Autowired
        RepoRemainDetailMapper rrdmapper;

        @Autowired
        RepoRemainMapper rrmapper;

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

    @Transactional
    public List<ClassRemainRes> getClassRemain(Integer classId){

        List<ClassRemainRes> list = null;

            if(classId == 0){
                list = rrmapper.getAllClassRemain();
            }else{
                list = rrmapper.getOneClassRemain(classId);
            }

        return list;
    }

    public PageInfo<RemainDetailRes> selectRemainDetail(RemainDetailReq req){

        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        List<RemainDetailRes> list  = rrdmapper.selectRemainDetail(req);

        PageInfo<RemainDetailRes> info = new PageInfo<>(list);

        return info;
    }

    public RemainDetailTimesSupRes getTimesAndSup(String id){

        RemainDetailTimesSupRes rdts = new RemainDetailTimesSupRes();

        int time = rrdmapper.selectAllTimes(id);

        List<Integer> times = new ArrayList<>(time);

        for (int i = 1 ; i <= time ; i++ ) {
            times.add(i);
        }

        rdts.setTimes(times);


        rdts.setSuppliers(rrdmapper.selectSAllSup(id));

        return rdts;
    }

}
