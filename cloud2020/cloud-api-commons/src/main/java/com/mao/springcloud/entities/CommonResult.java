package com.mao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: lloam
 * Date: 2021/9/4 19:18
 * Description: 方法返回实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    // 404 not_found

    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}