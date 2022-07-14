package com.codewater.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ： CodeWater
 * @create ：2022-07-14-20:16
 * @Function Description ：
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //添加负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
}
