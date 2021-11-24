package com.example.springcloudjtaatomikos;

import com.example.springcloudjtaatomikos.config.DB1Config;
import com.example.springcloudjtaatomikos.config.DB2Config;
import com.example.springcloudjtaatomikos.config.DB3Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {DB1Config.class, DB2Config.class, DB3Config.class})
public class SpringCloudJtaAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudJtaAtomikosApplication.class, args);
    }

}
