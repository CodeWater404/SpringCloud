package com.codewater.springcloud.service;

import com.codewater.springcloud.entities.CommonResult;
import com.codewater.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ： CodeWater
 * @create ：2022-07-22-23:34
 * @Function Description ：
 */
@FeignClient(value = "nacos-payment-provider" , fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
