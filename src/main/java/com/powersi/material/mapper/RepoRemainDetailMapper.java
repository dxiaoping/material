package com.powersi.material.mapper;

import com.powersi.material.pojo.RepoRemainDetail;
import com.powersi.material.pojo.RepoRemainDetailExample;
import com.powersi.material.pojo.RepoRemainDetailKey;
import com.powersi.material.pojo.Supplier;
import com.powersi.material.pojo.requestBody.RemainDetailReq;
import com.powersi.material.pojo.requestBody.RepoRemainReq;
import com.powersi.material.pojo.responseBody.RemainDetailRes;
import com.powersi.material.pojo.responseBody.RepoRemainRes;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    //查询库存明细
    List<RemainDetailRes> selectRemainDetail(RemainDetailReq req);

    //查询供应商 与 批次
    @Select("select times \n" +
            "from \n" +
            "repo_remain_detail rrd,repo_remain rr \n" +
            "where \n" +
            "rr.id = rrd.repo_remain_id and rr.item_id = #{id} \n" +
            "order by times desc \n" +
            "limit 1 ")
    Integer selectAllTimes(@Param("id") String id);

    @Select("select \n" +
            "DISTINCT(s.id),s.supplier_name\n" +
            "from \n" +
            "supplier s,repo_remain_detail rrd,repo_remain rr \n" +
            "where \n" +
            "rr.id = rrd.repo_remain_id and s.id = rrd.supplier_id and rr.item_id = #{id} ")
    List<Supplier> selectSAllSup(@Param("id") String id);

}