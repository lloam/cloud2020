package com.mao.springcloud.controller;

import com.mao.springcloud.entities.CommonResult;
import com.mao.springcloud.entities.Payment;
import com.mao.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: lloam
 * Date: 2021/9/7 15:59
 * Description:
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {

        // open-feign-ribbon，客户端一般默认等待 1 秒钟
        return paymentFeignService.paymentFeignTimeout();

    }
}
