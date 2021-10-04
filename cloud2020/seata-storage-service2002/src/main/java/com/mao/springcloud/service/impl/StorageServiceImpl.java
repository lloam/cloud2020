package com.mao.springcloud.service.impl;

import com.mao.springcloud.dao.StorageDAO;
import com.mao.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: lloam
 * Date: 2021/10/4 10:44
 * Description:
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDAO storageDAO;

    /**
     * 扣减库存你
     * @param productId
     * @param count
     */
    public void decrease(Long productId, Integer count) {
        log.info("------>storage-service 中扣减库存开始");
        storageDAO.decrease(productId, count);
        log.info("------>storage-service 中扣减库存结束");
    }
}
