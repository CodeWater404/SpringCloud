package com.codewater.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ： CodeWater
 * @create ：2022-07-18-13:35
 * @Function Description ：
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        
        routes.route( "path_route_codewater" , r -> r.path("/guonei") //本机放问的：localhost:9527/guonei
                .uri("http://news.baidu.com/guonei")).build(); //实际地址http://news.baidu.com/guonei
        return routes.build();
    }
}
