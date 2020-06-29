package com.powersi.material.configure;

import com.powersi.material.commons.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Autowired
    private ConfigProperties config;
    /**
     * 配置雪花数实例
     */
    @Bean
    public Id id() {
        return new Id(config.getId().getWorkerId(), config.getId().getDatacenterId());
    }

}
