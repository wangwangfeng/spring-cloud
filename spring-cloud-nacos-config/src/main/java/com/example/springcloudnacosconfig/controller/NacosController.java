package com.example.springcloudnacosconfig.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: NacosController
 * @Description: TODO
 * @Date: 2021/11/17 16:58
 * @author: wwf
 */
@RefreshScope
@RestController
@Slf4j
@RequestMapping("/config")
public class NacosController {

    @Value("${version:默认值}")
    private String version;

    @Value("${conf:默认值}")
    private String conf;

    /**
     * http://localhost:8080/config/test
     **/
    @GetMapping(value = "/test")
    public String nacosTest() {
        log.info("测试开始+++++");
        return version + ":" + conf;
    }

}
