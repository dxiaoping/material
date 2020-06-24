package com.powersi.material.configure;

import java.io.File;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix ="config",ignoreInvalidFields = true,ignoreUnknownFields = true)
@Configurable
@Configuration
@Data
@Slf4j
public class ConfigProperties {

    /**
     * 雪花数配置
     */
    private Id id;

    /**
     * 项目图片条形码图片路径保存在本地
     */
//    private String root = "";

    /**
     *
     */
    public File rootFile;


    @Data
    public static class Id{
        /**
         * 雪花数的节点编号，0-31，默认0
         */
        private Long workerId = 0L;
        /**
         * 雪花数的数据中心编号，0-31，默认0
         */
        private Long datacenterId = 0L;
    }


}
