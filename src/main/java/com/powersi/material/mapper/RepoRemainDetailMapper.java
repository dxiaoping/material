package com.powersi.material.mapper;

import com.powersi.material.pojo.RepoRemainDetail;
import com.powersi.material.pojo.RepoRemainDetailExample;
import com.powersi.material.pojo.RepoRemainDetailKey;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.responseBody.RepoRemainRes;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

@Mapper()
public interface RepoRemainDetailMapper {
    int countByExample(RepoRemainDetailExample example);

    int deleteByExample(RepoRemainDetailExample example);

    int deleteByPrimaryKey(RepoRemainDetailKey key);

    int insert(RepoRemainDetail record);

    int insertSelective(RepoRemainDetail record);

    List<RepoRemainDetail> selectByExample(RepoRemainDetailExample example);

    RepoRemainDetail selectByPrimaryKey(RepoRemainDetailKey key);

    int updateByExampleSelective(@Param("record") RepoRemainDetail record, @Param("example") RepoRemainDetailExample example);

    int updateByExample(@Param("record") RepoRemainDetail record, @Param("example") RepoRemainDetailExample example);

    int updateByPrimaryKeySelective(RepoRemainDetail record);

    int updateByPrimaryKey(RepoRemainDetail record);

    List<RepoRemainRes> selectAllRemain(RepoRemainReq req);


}