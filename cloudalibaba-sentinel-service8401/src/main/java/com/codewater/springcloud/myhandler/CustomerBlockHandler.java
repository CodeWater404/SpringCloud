package com.codewater.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.codewater.springcloud.entities.CommonResult;

/**
 * @author ： CodeWater
 * @create ：2022-07-22-22:30
 * @Function Description ：统一处理异常类
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException( BlockException exception ){
        return new CommonResult( 44444 , "按照客户自定义， global handlerException -------1");
    }

    public static CommonResult handlerException2( BlockException exception ){
        return new CommonResult( 44444 , "按照客户自定义， global handlerException -------2");
    }
}
