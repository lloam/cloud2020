package com.mao.springcloud.controller;

import com.mao.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: lloam
 * Date: 2021/9/7 21:37
 * Description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*****result："+result);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id)
    {
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        log.info("*****result："+result);
        return result;
    }

    public String paymentInfo_TimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付繁忙，请 10 秒后再试或自己运行出错检查自己，/(ㄒoㄒ)/~~";
    }


    /**
     * 通用全局降级处理方法
     * 有使用自己特有的降级方法就用自己特有的，没有就是用通用的
     * @return
     */
    public String payment_global_fallbackMethod() {
        return "Global FallBack Method";
    }
}
