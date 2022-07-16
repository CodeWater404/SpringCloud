package com.codewater.springcloud.service;

import com.codewater.springcloud.entities.CommonResult;
import com.codewater.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ： CodeWater
 * @create ：2022-07-16-17:46
 * @Function Description ：
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")  //远程调用的服务名称
public interface PaymentFeignService {
    
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();

}
