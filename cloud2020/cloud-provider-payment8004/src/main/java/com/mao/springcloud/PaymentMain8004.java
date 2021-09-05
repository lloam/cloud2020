package com.mao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Author: lloam
 * Date: 2021/9/5 17:20
 * Description: 该服务将注册到 zookeeper 注册中心
 */
@SpringBootApplication
// 该注解用于向使用 consul 或者 zookeeper 作为注册中心时注册服务
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
