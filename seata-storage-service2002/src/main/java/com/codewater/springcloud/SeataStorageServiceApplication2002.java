package com.codewater.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-17:36
 * @Function Description ：
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageServiceApplication2002
{
    public static void main(String[] args)
    {
        SpringApplication.run(SeataStorageServiceApplication2002.class, args);
    }
}
