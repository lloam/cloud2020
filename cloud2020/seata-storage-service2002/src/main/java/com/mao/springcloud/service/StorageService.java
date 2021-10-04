package com.mao.springcloud.service;

/**
 * Author: lloam
 * Date: 2021/10/4 10:44
 * Description:
 */
public interface StorageService {

    // 减少库存
    void decrease(Long productId, Integer count);
}
