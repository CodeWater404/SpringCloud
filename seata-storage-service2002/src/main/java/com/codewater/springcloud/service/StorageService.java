package com.codewater.springcloud.service;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-17:40
 * @Function Description ：
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
