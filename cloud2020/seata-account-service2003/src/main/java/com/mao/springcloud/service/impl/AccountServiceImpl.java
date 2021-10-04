package com.mao.springcloud.service.impl;

import com.mao.springcloud.dao.AccountDAO;
import com.mao.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Author: lloam
 * Date: 2021/10/4 11:10
 * Description:
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    /**
     * 扣减库存
     * @param userId
     * @param money
     */
    public void decrease(Long userId, BigDecimal money) {
        log.info("------>调用 account-service 扣减库存开始");
        // 模拟超时异常，全局事务回滚
        // 暂停几秒钟线程
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDAO.decrease(userId, money);
        log.info("------>调用 account-service 扣减库存结束");
    }
}
