package com.yicj.study.service.impl;

import com.yicj.study.component.RabbitMQConfirm;
import com.yicj.study.entity.User;
import com.yicj.study.service.IRabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements IRabbitMQService{

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting ;

    @Value("${rabbitmq.queue.user}")
    private String userRouting ;

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Autowired
    private RabbitMQConfirm rabbitMQConfirm ;

    @Override
    public void sendMsg(String message) {
        rabbitTemplate.setConfirmCallback(rabbitMQConfirm);
        rabbitTemplate.convertAndSend(msgRouting,message);
    }

    @Override
    public void sendUser(User user) {
        rabbitTemplate.setConfirmCallback(rabbitMQConfirm);
        rabbitTemplate.convertAndSend(userRouting,user);
    }
}
