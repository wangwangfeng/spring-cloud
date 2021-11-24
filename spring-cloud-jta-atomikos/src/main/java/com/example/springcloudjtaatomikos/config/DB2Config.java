package com.example.springcloudjtaatomikos.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname: DB2Config
 * @Description: TODO
 * @Date: 2021/11/22 16:20
 * @author: wwf
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class DB2Config {

    @Value("${spring.datasource.db2.jdbc-url}")
    private String url_jdbc;

    @Value("${spring.datasource.db2.username}")
    private String username;

    @Value("${spring.datasource.db2.password}")
    private String password;

}
