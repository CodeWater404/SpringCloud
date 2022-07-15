package com.codewater.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-07-15-18:07
 * @Function Description ：
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";
    
    @Resource
    private RestTemplate  restTemplate;
    
    @GetMapping(value="/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk" , String.class );
        return result;
    }
    
}
