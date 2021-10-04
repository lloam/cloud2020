package com.mao.springcloud;

import com.mao.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * Author: lloam
 * Date: 2021/10/4 15:21
 * Description:
 */
@SpringBootTest
public class Test {

    @Autowired
    private AccountService accountService;

    @org.junit.jupiter.api.Test
    public void test() {
        accountService.decrease(1L, new BigDecimal(100));
    }
}
