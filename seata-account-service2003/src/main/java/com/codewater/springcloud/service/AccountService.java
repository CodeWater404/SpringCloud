package com.codewater.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author ： CodeWater
 * @create ：2022-07-23-17:56
 * @Function Description ：
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
