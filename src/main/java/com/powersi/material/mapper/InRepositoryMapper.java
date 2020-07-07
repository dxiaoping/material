package com.powersi.material.mapper;

import com.github.pagehelper.PageInfo;
import com.powersi.material.pojo.InRepository;
import com.powersi.material.pojo.InRepositoryExample;
import com.powersi.material.pojo.requestBody.SelectInRepoReq;
import com.powersi.material.pojo.responseBody.SelectInRepoRes;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface InRepositoryMapper {
    int countByExample(InRepositoryExample example);

    int deleteByExample(InRepositoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(InRepository record);

    int insertSelective(InRepository record);

    List<InRepository> selectByExample(InRepositoryExample example);

    InRepository selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InRepository record, @Param("example") InRepositoryExample example);

    int updateByExample(@Param("record") InRepository record, @Param("example") InRepositoryExample example);

    int updateByPrimaryKeySelective(InRepository record);

    int updateByPrimaryKey(InRepository record);





    @Update("update in_repository set employee_id = #{employeeId},in_repo_date = #{inRpoDate},in_repo_state = 1 where id = #{id}")
    int updateInRepo(@Param("employeeId") String employeeId, @Param("inRpoDate") Date inRpoDate, @Param("id") String id);

    List<SelectInRepoRes> selectAllInRepo(SelectInRepoReq req);







}