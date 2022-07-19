package com.codewater.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-07-19-1:38
 * @Function Description ：
 */
@RestController
@Slf4j
public class ConfigClientController {
    
    @Value("${server.port}")
    private String serverPort;
    
    @Value("${config.info}")
    private String configInfo;
    
    @GetMapping("/configInfo")
    public String configInfo(){
        return "serverPort: " + serverPort + "\t\n\n  configInfo: " + configInfo ;
    }
}
