package com.codewater.springcloud.domain;

import lombok.Data;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-17:39
 * @Function Description ：
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
