package com.powersi.material;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.powersi.material.*"})
@MapperScan("com.powersi.material.mapper")
public class MaterialApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterialApplication.class, args);
    }

}
