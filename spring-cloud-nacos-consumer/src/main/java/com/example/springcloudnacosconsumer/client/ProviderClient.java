package com.example.springcloudnacosconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname: ProviderClient
 * @Description: TODO
 * @Date: 2021/11/18 13:59
 * @author: wwf
 */
@FeignClient(value = "nacos-provider")
public interface ProviderClient {

    // 这里这里对应provider原接口地址，必须一样！
    @GetMapping("/service")
    String service();

}
