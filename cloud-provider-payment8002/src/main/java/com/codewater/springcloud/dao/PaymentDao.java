package com.codewater.springcloud.dao;

import com.codewater.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-23:02
 * @Function Description ：
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    
    public Payment getPaymentById(@Param("id") Long id);
}
