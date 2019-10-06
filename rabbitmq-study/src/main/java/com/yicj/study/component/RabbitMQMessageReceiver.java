package com.yicj.study.component;

import com.yicj.study.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQMessageReceiver {

    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void receiveMsg(String message){
        log.info("收到消息: 【{}】",message);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveUser(User user){
        log.info("收到用户信息: 【{}】",user);
    }
}
