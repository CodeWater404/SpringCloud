package com.codewater.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-07-20-22:04
 * @Function Description ：
 */
@Component
@EnableBinding( Sink.class )
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;
    
    @StreamListener( Sink.INPUT )
    public void input(Message<String> message ){  //类型跟生产者一方保持一致
//        payLoad()也是跟消费者保持
        System.out.println( "消费者1号， ----》接收到的消息：" + message.getPayload() + "\t" + serverPort );
                
    }
}
