package com.mao.springcloud.service;

import com.mao.springcloud.entities.CommonResult;
import com.mao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * Author: lloam
 * Date: 2021/10/2 11:31
 * Description:
 * feign 降级方法
 */
@Component
public class PaymentFallbackService implements PaymentService {

    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回，---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
