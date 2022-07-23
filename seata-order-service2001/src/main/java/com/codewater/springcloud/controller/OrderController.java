package com.codewater.springcloud.controller;

import com.codewater.springcloud.domain.CommonResult;
import com.codewater.springcloud.domain.Order;
import com.codewater.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-16:05
 * @Function Description ：
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

