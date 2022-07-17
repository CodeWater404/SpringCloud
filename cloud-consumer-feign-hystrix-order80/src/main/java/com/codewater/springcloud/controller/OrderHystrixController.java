package com.codewater.springcloud.controller;

import com.codewater.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-16:08
 * @Function Description ：
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback="payment_Global_FallbackMethod")
public class OrderHystrixController {
    
    @Resource
    private PaymentHystrixService paymentHystrixService;
    
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id ){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    /**
     * 消费端的服务降级,处理超过1.5秒就用指定方法处理
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod="paymentTimeOutFallbackMethod" , commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" , value="5000")
    })
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id ){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    /**
     * 单独的指定的fallback降级方法
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id ){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o" ;
    }

    /**
     * 全局fallback（降级）方法
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试！！o(╥﹏╥)o ";
    }
}
