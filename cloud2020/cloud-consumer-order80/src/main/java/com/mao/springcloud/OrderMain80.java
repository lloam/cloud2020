package com.mao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: lloam
 * Date: 2021/9/4 19:15
 * Description: 服务消费主启动类
 */
@SpringBootApplication
// 标注这是一个 Eureka-Client 客户端
@EnableEurekaClient
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
