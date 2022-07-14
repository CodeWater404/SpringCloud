package com.codewater.springcloud.controller;

import com.codewater.springcloud.entities.CommonResult;
import com.codewater.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-07-14-20:15
 * @Function Description ：
 */
@RestController
@Slf4j
public class OrderController {
//    url写死
//    public static final String PAYMENT_URL = "http://localhost:8001";
//    动态获取应用名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    
    @Resource 
    private RestTemplate restTemplate;
    
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject( PAYMENT_URL + "/payment/create" , payment , CommonResult.class );
    }
    
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject( PAYMENT_URL + "/payment/get/" + id , CommonResult.class );
    }
}
