package com.example.springcloudjtaatomikos.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname: DB3Config
 * @Description: TODO
 * @Date: 2021/11/23 16:18
 * @author: wwf
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.db3")
public class DB3Config {

    @Value("${spring.datasource.db3.jdbc-url}")
    private String url_jdbc;

    @Value("${spring.datasource.db3.username}")
    private String username;

    @Value("${spring.datasource.db3.password}")
    private String password;

}
