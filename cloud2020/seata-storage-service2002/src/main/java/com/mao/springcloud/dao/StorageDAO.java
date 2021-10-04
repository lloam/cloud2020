package com.mao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author: lloam
 * Date: 2021/10/4 10:39
 * Description:
 */
@Mapper
public interface StorageDAO {

    // 减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
