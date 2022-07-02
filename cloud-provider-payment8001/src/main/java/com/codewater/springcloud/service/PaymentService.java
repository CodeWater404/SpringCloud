package com.codewater.springcloud.service;

import com.codewater.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-23:17
 * @Function Description ：
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
