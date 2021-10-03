package com.mao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mao.springcloud.entities.CommonResult;
import com.mao.springcloud.entities.Payment;
import com.mao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Author: lloam
 * Date: 2021/10/2 10:03
 * Description:
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback")   // 没有配置
    // @SentinelResource(value = "fallback", fallback = "handlerFallback")   // fallback 只负责业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler")   // blockHandler 只负责 Sentinel 控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = IllegalAccessException.class)   // 两个都配置
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) throws IllegalAccessException {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalAccessException("IllegalAccessException 非法参数异常");
        }else if (result.getData() == null){
            throw new NullPointerException("NullPointException，该 ID 没有对应记录，空指针异常");
        }
        return result;
    }
    // 本例是 fallback
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常 handlerFallback，异常内容：" + e.getMessage(), payment);
    }
    // 本例是 blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException exception) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler-sentinel 限流，无此流水：blockException" + exception.getMessage(), payment);
    }

    // --------------OpenFeign
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        return result;
    }
}
