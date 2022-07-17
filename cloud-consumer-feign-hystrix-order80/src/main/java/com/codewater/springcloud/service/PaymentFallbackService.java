package com.codewater.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-17:35
 * @Function Description ：
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id){
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }
    
    @Override
    public String paymentInfo_TimeOut(Integer id){
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
