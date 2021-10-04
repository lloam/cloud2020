package com.mao.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: lloam
 * Date: 2021/10/3 21:20
 * Description: 统一返回给前端的实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
