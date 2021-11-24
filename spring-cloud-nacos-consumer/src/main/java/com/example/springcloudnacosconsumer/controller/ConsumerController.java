package com.example.springcloudnacosconsumer.controller;

import com.example.springcloudnacosconsumer.client.ProviderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: ConsumerController
 * @Description: 服务消费者
 * @Date: 2021/11/18 14:02
 * @author: wwf
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    /**
     * http://127.0.0.1:9018/consumer/service
     **/
    @GetMapping("/consumer/service")
    public String service() {
        log.info("消费者访问-consumer");
        String service = providerClient.service();
        return "消费者访问-consumer" + "  |  " + service;
    }


}
