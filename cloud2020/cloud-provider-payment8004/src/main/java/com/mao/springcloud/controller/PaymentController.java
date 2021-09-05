package com.mao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Author: lloam
 * Date: 2021/9/5 17:23
 * Description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentZk()
    {
        return "springcloud with zookeeper："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
