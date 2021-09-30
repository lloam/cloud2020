package com.mao.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lloam
 * Date: 2021/9/29 21:03
 * Description:
 */
@RestController
public class FlowLimitController
{

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
//        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName());
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }


    @GetMapping("/testD")
    public String testD() throws InterruptedException {
//        Thread.sleep(1000);
//        System.out.println("testD 测试 RT");
        int i = 10/0;
        System.out.println("testD 异常比例");
        return "------testD";
    }
}
