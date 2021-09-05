package com.mao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: lloam
 * Date: 2021/9/4 19:18
 * Description: Payment 实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
