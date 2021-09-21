package com.mao.springcloud.controller;

import com.mao.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lloam
 * Date: 2021/9/21 11:45
 * Description:
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;


    @GetMapping("/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

}
