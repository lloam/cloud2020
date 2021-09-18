package com.mao.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Author: lloam
 * Date: 2021/9/7 20:27
 * Description:
 */
@Service
public class PaymentService
{

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id)
    {
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK，id"+id+"\t"+"o(n_n)o哈哈~";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            // 设置线程请求超时时间为 3 秒
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id)
    {
        int timeNumber = 5;
        // int age = 10/0; // 模拟出错
        try {
            System.out.println("未降级前服务线程名为：" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("出错后服务线程名为：" + Thread.currentThread().getName());
        }
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_Timeout，id"+id+"\t"+"o(n_n)o哈哈~"+"  耗时 "+timeNumber+" 秒钟";
    }


    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "  系统繁忙或者运行报错，请稍后再试，id：" + id + "\t" +  "/(ㄒoㄒ)/~~";
    }
}
