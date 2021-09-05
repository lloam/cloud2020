package com.mao.springcloud.service;

import com.mao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Author: lloam
 * Date: 2021/9/4 17:32
 * Description: Payment service 接口
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
