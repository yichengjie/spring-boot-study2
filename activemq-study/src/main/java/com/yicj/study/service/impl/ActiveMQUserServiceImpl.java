package com.yicj.study.service.impl;

import com.yicj.study.entity.User;
import com.yicj.study.service.IActiveMQUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActiveMQUserServiceImpl implements IActiveMQUserService {
    //自定义地址
    private static final String MY_DESTINATION = "my-destination";
    //@Autowired
    //private JmsTemplate jmsTemplate ;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendUser(User user) {
        log.info("发送消息:【{}】", user);
        jmsMessagingTemplate.convertAndSend(MY_DESTINATION, user);
    }

    @Override
    //监控自定义地址
    @JmsListener(destination = MY_DESTINATION)
    public void receiveUser(User user) {
        log.info("接收消息: 【{}】", user);
    }
}
