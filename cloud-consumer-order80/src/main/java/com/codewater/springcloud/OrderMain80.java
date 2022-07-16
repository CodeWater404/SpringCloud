package com.codewater.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ： CodeWater
 * @create ：2022-07-14-20:07
 * @Function Description ：消费端，不需要操作数据库，只要调用
 */
@SpringBootApplication
@EnableEurekaClient
//name = "CLOUD-PAYMENT-SERVICE" 服务提供方的应用名称  configuration是自定义调用负载均衡算法
//@RibbonClient( name = "CLOUD-PAYMENT-SERVICE" , configuration= MySelfRule.class )
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class , args);
    }
}
