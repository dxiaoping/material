package com.powersi.material.repository;

import com.powersi.material.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //使用JAP实现查询用户信息
    User findByUsername(String username);

}
