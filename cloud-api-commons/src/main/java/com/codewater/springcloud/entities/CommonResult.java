package com.codewater.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ： CodeWater
 * @create ：2022-07-14-20:10
 * @Function Description ：
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
