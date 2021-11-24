package com.example.springcloudnacosprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: ConsumerController
 * @Description: 服务提供者
 * @Date: 2021/11/18 12:02
 * @author: wwf
 */
@RestController
@Slf4j
public class ProviderController {

    @GetMapping("/service")
    public String service() {
        log.info("服务提供者-provider");
        return "服务提供者-provider";
    }

}
