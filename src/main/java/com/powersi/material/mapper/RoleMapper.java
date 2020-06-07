package com.powersi.material.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleMapper {

    Set<String> findByUid(Long uid);
}
