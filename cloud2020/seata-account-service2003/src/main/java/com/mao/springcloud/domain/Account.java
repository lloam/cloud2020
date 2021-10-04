package com.mao.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Author: lloam
 * Date: 2021/10/4 11:05
 * Description: 账户实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;

    // 用户 id
    private Long userId;

    // 用户总余额
    private BigDecimal total;

    // 已用余额
    private BigDecimal used;

    // 剩余余额
    private BigDecimal residue;
}
