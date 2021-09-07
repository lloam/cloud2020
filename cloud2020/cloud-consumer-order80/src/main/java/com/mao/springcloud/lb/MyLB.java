package com.mao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: lloam
 * Date: 2021/9/7 11:07
 * Description:
 */
@Component
public class MyLB implements LoadBalancer {


    private AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 获取服务请求的次数
     * @return
     */
    public final int getAndIncrement() {
        // 当前总共访问的次数
        int current;

        // 当前第几次请求
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("*****第几次访问，次数next：" + next);

        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        // 计算调用服务的下标
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
