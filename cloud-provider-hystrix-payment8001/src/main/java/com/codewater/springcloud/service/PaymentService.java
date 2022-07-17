package com.codewater.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-15:00
 * @Function Description ：
 */
@Service
public class PaymentService {

    //==========================服务降级============================
    
    /**
     * 能正常访问的， ok
     * @param id
     * @return
     */
    public String paymentInfo_OK( Integer id ){
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK, id : " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 只要当前方法处理超过value(设置的最大峰值)或者出现异常，就会执行fallbackMethod方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutHandler" , commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="5000")
    })
    public String paymentInfo_TimeOut( Integer id ){
        int timeNumber = 3;
//        int i = 10 / 0 ;
        try{
            TimeUnit.SECONDS.sleep( timeNumber ) ;
        }catch( InterruptedException e ){
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_Timeout , id: " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时（s）: " + timeNumber ;
//        return "线程池： " + Thread.currentThread().getName() + "   paymentInfo_Timeout , id: " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时（s）: " ;
        
    }
    
//    指定处理服务降级的处理
    public String paymentInfo_TimeOutHandler( Integer id ){
        return "线程池： " + Thread.currentThread().getName() + "   8001系统繁忙或运行报错，请稍后再试 , id : " + id + "\t" + "o(╥﹏╥)o" ;
    }
    
    
    //==========================服务熔断============================
    @HystrixCommand(fallbackMethod="paymentCircuitBreaker_fallback" , commandProperties={
            @HystrixProperty(name="circuitBreaker.enabled" , value="true" ), // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold" , value="10" ), // 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds" , value="10000" ),// 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage" , value="60" ),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if( id < 0 ){
            throw new RuntimeException("//==========================id不能为负数============================");
        }
        String serialNumber  = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功， 流水号：" + serialNumber ;
    }
    
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id ){
        return "//==========================id不能为负数！请稍后再试o(╥﹏╥)o---============================" + id;
    }

    

}
