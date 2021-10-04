package com.mao.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Author: lloam
 * Date: 2021/10/4 11:09
 * Description:
 */
public interface AccountService {

    // 扣减余额
    void decrease(Long userId, BigDecimal money);
}
