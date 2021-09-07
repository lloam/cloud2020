package com.mao.springcloud.service;

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


    public String paymentInfo_Timeout(Integer id)
    {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_Timeout，id"+id+"\t"+"o(n_n)o哈哈~"+"  耗时 "+timeNumber+" 秒钟";
    }
}
