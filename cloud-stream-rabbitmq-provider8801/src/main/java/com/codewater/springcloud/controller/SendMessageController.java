package com.codewater.springcloud.controller;

import com.codewater.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-07-20-0:54
 * @Function Description ：
 */
@RestController
public class SendMessageController {
    @Resource 
    private IMessageProvider messageProvider;
    
    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
