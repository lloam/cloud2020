package com.mao.springcloud.dao;

import com.mao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author: lloam
 * Date: 2021/9/4 17:19
 * Description: dao 接口
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
