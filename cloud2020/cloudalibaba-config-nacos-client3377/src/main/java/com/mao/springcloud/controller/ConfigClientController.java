package com.mao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lloam
 * Date: 2021/9/22 20:49
 * Description:
 */
@RestController
@RefreshScope       // 支持 Nacos 的动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
