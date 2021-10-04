package com.mao.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: lloam
 * Date: 2021/10/4 10:34
 * Description: 库存实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;
    // 商品 id
    private Long productId;

    // 商品总量
    private Integer total;

    // 库存出售量
    private Integer used;

    // 库存剩余量
    private Integer residue;
}
