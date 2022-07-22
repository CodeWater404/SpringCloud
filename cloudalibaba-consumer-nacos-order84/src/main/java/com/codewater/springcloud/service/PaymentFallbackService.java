package com.codewater.springcloud.service;

import com.codewater.springcloud.entities.CommonResult;
import com.codewater.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-07-22-23:36
 * @Function Description ：
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL( Long id){
        return new CommonResult<>(4444 , "服务器降级返回,-----PaymentFallbackService" , new Payment( id , "errorSerial") );
    }
}
