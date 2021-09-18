package com.mao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Author: lloam
 * Date: 2021/9/18 11:55
 * Description: feign 客户端降级处理
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallBackService 的 paymentInfo_OK 方法降级 /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallBackService 的 paymentInfo_Timeout 方法降级 /(ㄒoㄒ)/~~";
    }
}
