package com.yicj.study.service;

public interface IActiveMQService {
    //发送消息
    void sendMsg(String msg) ;
    //接收消息
    void receiveMsg(String msg) ;
}
