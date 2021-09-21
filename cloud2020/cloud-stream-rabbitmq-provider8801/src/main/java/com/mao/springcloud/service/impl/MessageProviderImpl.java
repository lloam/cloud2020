package com.mao.springcloud.service.impl;

import com.mao.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Author: lloam
 * Date: 2021/9/21 11:27
 * Description:
 * 不需要加 @Service 注解，因为这个类是和 RabbitMQ 处理的
 * 定义消息的推送管道
 */
@EnableBinding(Source.class)    // 定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 消息发送管道

    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****serial：" + serial);
        return serial;
    }
}
