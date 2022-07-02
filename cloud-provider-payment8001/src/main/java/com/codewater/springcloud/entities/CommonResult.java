package com.codewater.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-22:56
 * @Function Description ：返回给前端通用的json字符串
 * 加T泛型更加通用
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>  {
    private Integer code;
    private String message;
    private T data;
    
    public CommonResult( Integer code , String message ){
        this( code , message , null );
    }
}
