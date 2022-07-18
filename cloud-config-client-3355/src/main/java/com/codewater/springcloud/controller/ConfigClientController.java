package com.codewater.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-07-18-19:14
 * @Function Description ：
 */
@RestController
public class ConfigClientController {
    
    @Value("${config.info}")
    private String configInfo ;
    
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
