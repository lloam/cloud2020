package com.mao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Author: lloam
 * Date: 2021/9/7 11:06
 * Description:
 */
public interface LoadBalancer {

    public ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
