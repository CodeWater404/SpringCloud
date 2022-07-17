package com.codewater.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-16:05
 * @Function Description ：
 */
@Component
//调用远程服务出现异常时，用实现类去服务降级
@FeignClient( value="CLOUD-PROVIDER-HYSTRIX-PAYMENT" , fallback=PaymentFallbackService.class)
public interface PaymentHystrixService {
    
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);
    
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
    
}
