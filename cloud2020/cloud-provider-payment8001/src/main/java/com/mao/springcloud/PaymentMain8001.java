package com.mao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: lloam
 * Date: 2021/9/4 17:02
 * Description: 支付子模块服务入口
 */
@SpringBootApplication
// 标注这是一个 Eureka-Client 客户端
@EnableEurekaClient
// 开启服务注册与发现
@EnableDiscoveryClient
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
