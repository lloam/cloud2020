package com.mao.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: lloam
 * Date: 2021/10/4 11:53
 * Description:
 */
@Configuration
@MapperScan({"com.mao.springcloud.dao"})
public class MyBatisConfig {
}
