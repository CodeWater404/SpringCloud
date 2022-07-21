package com.codewater.springcloud.controller;


import com.codewater.springcloud.entities.CommonResult;
import com.codewater.springcloud.entities.Payment;
import com.codewater.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-23:33
 * @Function Description ：
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource 
    private PaymentService paymentService;
    
//    获取配置文件中的端口
    @Value("${server.port}")
    private String serverPort;
    
    @Resource
    private DiscoveryClient discoveryClient;
    
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create( payment );
        log.info("========================插入结果： " + result );
        
        if( result > 0 ){
            return new CommonResult( 200 , "插入数据成功，serverport：" + serverPort , result );
        }else{
            return new CommonResult( 444 , "插入数据失败"  , null );
        }
    }
    
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id ){
        Payment payment = paymentService.getPaymentById( id );
        log.info("========查询结果：==================");
        
        if( payment != null ){
            return new CommonResult( 200 , "查询成功, serverport: " + serverPort  , payment );
        }else{
            return new CommonResult( 444 , "没有对应记录， 查询ID： " + id , null );
        }
    }
    
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for( String element : services ){
            log.info( "****element: " + element );
        }
        
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri() );
        }
        
        return this.discoveryClient;
    }

    /**
     * 调用自定义的负载均衡
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        
        return serverPort;
    }
    
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep( 3 );
        }catch(InterruptedException e ){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to codeWater，O(∩_∩)O哈哈~";
    }
}
