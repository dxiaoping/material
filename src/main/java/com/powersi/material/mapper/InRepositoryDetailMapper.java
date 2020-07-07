package com.powersi.material.mapper;

import com.powersi.material.pojo.InRepositoryDetail;
import com.powersi.material.pojo.InRepositoryDetailExample;
import com.powersi.material.pojo.InRepositoryDetailKey;
import com.powersi.material.pojo.requestBody.InRepositoryDetailReq;
import com.powersi.material.pojo.responseBody.InRepositoryDetailRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InRepositoryDetailMapper {
    int countByExample(InRepositoryDetailExample example);

    int deleteByExample(InRepositoryDetailExample example);

    int deleteByPrimaryKey(InRepositoryDetailKey key);

    int insert(InRepositoryDetail record);

    int insertSelective(InRepositoryDetail record);

    List<InRepositoryDetail> selectByExample(InRepositoryDetailExample example);

    InRepositoryDetail selectByPrimaryKey(InRepositoryDetailKey key);

    int updateByExampleSelective(@Param("record") InRepositoryDetail record, @Param("example") InRepositoryDetailExample example);

    int updateByExample(@Param("record") InRepositoryDetail record, @Param("example") InRepositoryDetailExample example);

    int updateByPrimaryKeySelective(InRepositoryDetail record);

    int updateByPrimaryKey(InRepositoryDetail record);

    List<InRepositoryDetailRes> selectInRepoDetail(InRepositoryDetailReq req);

}