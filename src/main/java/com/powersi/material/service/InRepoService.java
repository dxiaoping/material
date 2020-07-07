package com.powersi.material.service;

import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.InRepository;
import com.powersi.material.pojo.requestBody.InRepoReq;
import com.powersi.material.pojo.requestBody.InRepositoryDetailReq;
import com.powersi.material.pojo.requestBody.SelectInRepoReq;
import com.powersi.material.pojo.responseBody.InRepositoryDetailRes;
import com.powersi.material.pojo.responseBody.SelectInRepoRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface InRepoService {

    PageInfo<SelectInRepoRes> selectAllInRepo(SelectInRepoReq req);

    PageInfo<InRepositoryDetailRes> selectInRepoDetail(InRepositoryDetailReq req);

    boolean addInRepositoryDetail(InRepoReq req);

    public void insertInRepository(InRepository inRepository);

}
