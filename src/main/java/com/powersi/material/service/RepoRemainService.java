package com.powersi.material.service;

import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.responseBody.ClassRemainRes;
import com.powersi.material.pojo.responseBody.RepoRemainRes;

import java.util.List;

public interface RepoRemainService {

    /**
     * 查询库存情况
     * @param req
     * @return
     */
    PageInfo<RepoRemainRes> selectAllRemain(RepoRemainReq req, Integer pageNO, Integer pageSize);


    List<ClassRemainRes> getClassRemain(Integer classId);

}
