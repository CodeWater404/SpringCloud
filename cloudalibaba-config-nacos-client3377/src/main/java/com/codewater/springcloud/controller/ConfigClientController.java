package com.codewater.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-07-21-17:26
 * @Function Description ：
 */
@RestController
@RefreshScope //nacos动态刷新
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    
    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
