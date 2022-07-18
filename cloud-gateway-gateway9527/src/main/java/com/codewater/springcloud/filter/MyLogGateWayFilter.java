package com.codewater.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author ： CodeWater
 * @create ：2022-07-18-14:22
 * @Function Description ：
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    /**
     * 这里数过滤器处理的逻辑
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("//==========================come in MyLogGateWayFilter: " + new Date() );
        
        String uname = exchange.getRequest().getQueryParams().getFirst( "uname" );
        if( uname == null ){
            log.info( "//==========================用户名null ， 非法用户，o(╥﹏╥)o" );
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE );
            return exchange.getResponse().setComplete();
        }
        
        
        return chain.filter(exchange);
    }

    /**
     * 这里表示这个过滤器的优先级顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
