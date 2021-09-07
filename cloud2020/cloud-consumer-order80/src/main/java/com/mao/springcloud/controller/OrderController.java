package com.mao.springcloud.controller;

import com.mao.springcloud.entities.CommonResult;
import com.mao.springcloud.entities.Payment;
import com.mao.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Author: lloam
 * Date: 2021/9/4 19:19
 * Description:
 */
@RestController
@Slf4j
public class OrderController {

    // private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            CommonResult<Payment> result = entity.getBody();
            return result;
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }


    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {

        // 获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        // 获取负载均衡访问的服务
        ServiceInstance instance = loadBalancer.instance(instances);

        // 获取服务uri
        URI uri = instance.getUri();

        // 调用
        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }

}
