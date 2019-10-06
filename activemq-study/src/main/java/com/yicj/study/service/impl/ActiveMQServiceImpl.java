package com.yicj.study.service.impl;

import com.yicj.study.service.IActiveMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActiveMQServiceImpl implements IActiveMQService {


    @Value("${spring.jms.template.default-destination}")
    private String destination ;
    //springboot自动生成的jmsTemplate
    //@Autowired
    //private JmsTemplate jmsTemplate ;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate ;

    @Override
    public void sendMsg(String msg) {
        log.info("发送消息: 【{}】",msg);
        //注意这里如果不传入地址会报错!!!!,报jmsMessagingTemplate未设置默认地址
        //jmsMessagingTemplate.convertAndSend(msg);
        //自定义发送地址
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }

    @Override
    //使用注解，监听地址发送过来的消息
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String msg) {
        log.info("接收到的消息: 【{}】",msg);
    }
}
