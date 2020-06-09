package com.powersi.material.mapper;

import com.powersi.material.pojo.InRepository;
import com.powersi.material.pojo.InRepositoryExample;
import org.apache.ibatis.annotations.Param;

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
}