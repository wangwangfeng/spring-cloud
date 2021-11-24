package com.example.springcloudjtaatomikos.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname: DB1Config
 * @Description: TODO
 * @Date: 2021/11/22 16:18
 * @author: wwf
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.db1")
public class DB1Config {

    @Value("${spring.datasource.db1.jdbc-url}")
    private String url_jdbc;

    @Value("${spring.datasource.db1.username}")
    private String username;

    @Value("${spring.datasource.db1.password}")
    private String password;

}
