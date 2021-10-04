package com.mao.springcloud.dao;

import com.mao.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author: lloam
 * Date: 2021/10/3 21:49
 * Description:
 */
@Mapper
public interface OrderDAO {

    // 1、新建订单
    void create(Order order);
    // 2、修改订单状态从 0 改为 1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
