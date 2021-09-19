package com.mao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: lloam
 * Date: 2021/9/19 16:47
 * Description: 通过配置类来路由请求
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个 id 为 rout-name 的路由规则
     * 当访问地址 http:localhost:9527/guonei 时会自动转发到地址：http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_routh_com", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        routes.route("path_routh_mao2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
