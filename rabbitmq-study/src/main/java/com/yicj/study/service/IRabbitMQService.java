package com.yicj.study.service;

import com.yicj.study.entity.User;

public interface IRabbitMQService {

    /**
     * 发送消息
     * @param message
     */
    void sendMsg(String message) ;

    /**
     * 接收消息
     * @param user
     */
    void sendUser(User user) ;

}
