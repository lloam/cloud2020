package com.mao.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mao.springcloud.entities.CommonResult;

/**
 * Author: lloam
 * Date: 2021/10/1 21:50
 * Description: 用户自定义全局异常处理
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "按用户自定义，global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按用户自定义，global handlerException----2");
    }
}
