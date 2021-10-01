package com.mao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * @SentinelResource(value = "testHotKey", blockHandler = "deal_test_hotKey")
     * value：热点限流资源名
     * blockHandler：触发限流后的兜底方法
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_test_hotKey")
    public String test_hotKey(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2)
    {
        int i = 10/0;
        return "------test_hotKey";
    }
    /**
     * 热点限流方法
     * @param p1
     * @param p2
     * @return
     */
    public String deal_test_hotKey (String p1, String p2, BlockException exception)
    {
        return "------deal_test_hotKey";    // Sentinel 系统默认的提示：Block by Sentinel(flow limit)
    }
}
