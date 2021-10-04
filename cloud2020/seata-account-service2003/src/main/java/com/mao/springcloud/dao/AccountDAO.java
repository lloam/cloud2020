package com.mao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Author: lloam
 * Date: 2021/10/4 11:07
 * Description:
 */
@Mapper
public interface AccountDAO {

    // 扣减余额
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
