package com.codewater.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ： CodeWater
 * @create ：2022-07-15-21:07
 * @Function Description ：
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    
    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springCloud with consul : " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
