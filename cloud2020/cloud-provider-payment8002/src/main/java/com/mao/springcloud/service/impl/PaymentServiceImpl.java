package com.mao.springcloud.service.impl;

import com.mao.springcloud.dao.PaymentDao;
import com.mao.springcloud.entities.Payment;
import com.mao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: lloam
 * Date: 2021/9/4 17:32
 * Description: 接口实现类
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentDao paymentDao;

    /**
     * 创建一个 Payment
     * @param payment
     * @return
     */
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 根据 id 查询 Payment
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
