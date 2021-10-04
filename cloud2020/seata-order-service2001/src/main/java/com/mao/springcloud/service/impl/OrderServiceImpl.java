package com.mao.springcloud.service.impl;

import com.mao.springcloud.dao.OrderDAO;
import com.mao.springcloud.domain.Order;
import com.mao.springcloud.service.AccountService;
import com.mao.springcloud.service.OrderService;
import com.mao.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: lloam
 * Date: 2021/10/3 22:45
 * Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    /**
     * 创建订单 -> 调用库存服务扣减库存 -> 调用账户服务扣减账户余额 -> 修改订单状态
     * 简单说：
     * 下订单 -> 扣库存 -> 扣余额 -> 改状态
     * @param order
     */
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        // 1.新建订单
        log.info("------>开始新建订单");
        orderDAO.create(order);

        // 2.扣减库存
        log.info("------>订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------>订单微服务开始调用库存，做扣减 end");

        // 3.扣减余额
        log.info("------>订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>订单微服务开始调用账户，做扣减 end");

        // 4.修改订单的状态，从 0 到 1，1 代表已经完成
        log.info("------>修改订单状态开始");
        orderDAO.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");

        // 模拟异常
        int i = 10/0;

        log.info("------>下订单结束了，(*^_^*)哈哈~");
    }
}
