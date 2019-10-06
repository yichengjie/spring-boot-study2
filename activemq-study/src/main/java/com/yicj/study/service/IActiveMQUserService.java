package com.yicj.study.service;

import com.yicj.study.entity.User;

public interface IActiveMQUserService {
    //发送消息
    void sendUser(User user) ;
    //接收消息
    void receiveUser(User user) ;
}
