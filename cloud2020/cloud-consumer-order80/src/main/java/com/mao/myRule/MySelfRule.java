package com.mao.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: lloam
 * Date: 2021/9/6 16:01
 * Description: 自定义负载均衡算法
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule()
    {
        return new RandomRule();// 定义为随机
    }
}
