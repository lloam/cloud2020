package com.mao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author: lloam
 * Date: 2021/9/4 20:45
 * Description: eureka 注册中心主启动类
 */
@SpringBootApplication
// 标注这是一个 eureka 注册中心
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
