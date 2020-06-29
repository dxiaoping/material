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
@Configuration(value = "config")
@Data
@Slf4j
public class ConfigProperties {

    /**
     * 雪花数配置
     */
    private Id id;

    /**
     * 本地路径
     */
    private String root = "";

    /**
     * 保存条形码路径
     */
    public String picrootpath =  "D:/Codes/";

    /**
     *获取项目的根目录，解决不同的开发人员的根目录的路径不同问题
     */
    public File rootFile;

    /**
     * 	初始化时调用一次也是最后一次
     */
    @PostConstruct
    public void init() {
        if (root.equals("")) {
            try {
                String path = ConfigProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                path = java.net.URLDecoder.decode(path, "utf-8");
                if (path.indexOf("!") > -1) {
                    path = path.substring(0, path.indexOf("!"));
                }
                if (path.endsWith(".jar")) {
                    path = path.substring(0, path.lastIndexOf("/") + 1);
                    if (path.startsWith("file:")) {
                        path = path.substring(5);
                    }
                    rootFile = new File(path);
                } else {
                    rootFile = new File(path).getParentFile();
                }
            } catch (Exception e) {
                log.warn("获取当前目录失败", e);
                rootFile = new File("./").getAbsoluteFile();
            }
            root = rootFile.getAbsolutePath();
        } else {
            rootFile = new File(root);
        }
        log.info("当前项目使用的根目录：" + rootFile.getAbsolutePath());
    }


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
