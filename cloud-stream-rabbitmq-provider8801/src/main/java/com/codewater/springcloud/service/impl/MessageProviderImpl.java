package com.codewater.springcloud.service.impl;

import com.codewater.springcloud.service.IMessageProvider;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ： CodeWater
 * @create ：2022-07-20-0:51
 * @Function Description ：
 */
@EnableBinding(Source.class) //生产者
public class MessageProviderImpl implements IMessageProvider {
    
    @Resource
    private MessageChannel output;
    
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial: " + serial );
        return null;
    }
}
