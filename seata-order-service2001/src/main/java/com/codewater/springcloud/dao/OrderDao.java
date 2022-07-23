package com.codewater.springcloud.dao;

import com.codewater.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-16:01
 * @Function Description ：
 */
@Mapper
public interface OrderDao
{
    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
