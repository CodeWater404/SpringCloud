package com.codewater.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-17:36
 * @Function Description ：
 */
@Configuration
@MapperScan({"com.codewater.springcloud.dao"})
public class MyBatisConfig {
}
