package com.codewater.springcloud.service.impl;

import com.codewater.springcloud.dao.PaymentDao;
import com.codewater.springcloud.entities.Payment;
import com.codewater.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-23:18
 * @Function Description ：
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    
    public int create( Payment payment ){
        return paymentDao.create( payment );
        
    }
    
    public Payment getPaymentById( Long id ){
        return paymentDao.getPaymentById( id );
    }
}
