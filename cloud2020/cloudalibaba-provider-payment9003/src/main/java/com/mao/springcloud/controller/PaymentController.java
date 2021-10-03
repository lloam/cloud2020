package com.mao.springcloud.controller;

import com.mao.springcloud.entities.CommonResult;
import com.mao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lloam
 * Date: 2021/10/2 9:45
 * Description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L, new Payment(1L, "32jk4h3kj2h432ui4y32uiy4iu32"));
        map.put(2L, new Payment(2L, "32h4jk32hjk4h32kjh4kj32h4kj2"));
        map.put(3L, new Payment(3L, "hj5g76f7ghf87d69fgd87gd8f79d"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        if (payment != null) {
            CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
            return result;
        }else {
            return new CommonResult<>(400, "from mysql,serverPort:" + serverPort);
        }

    }
}
