package com.mao.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: lloam
 * Date: 2021/9/4 19:22
 * Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 开启 restTemplate 的负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
