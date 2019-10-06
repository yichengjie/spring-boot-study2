package com.yicj.study.controller;

import com.yicj.study.entity.User;
import com.yicj.study.service.IActiveMQService;
import com.yicj.study.service.IActiveMQUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/activemq")
public class ActiveMQController {

    @Autowired
    private IActiveMQService activeMQService ;
    @Autowired
    private IActiveMQUserService activeMQUserService ;

    //测试普通消息发送
    @GetMapping("/msg")
    public Map<String,Object> msg(String message){
        activeMQService.sendMsg(message);
        return result(true,message) ;
    }

    @GetMapping("/user")
    public Map<String,Object> user(Long id, String userName, String note){
        User user = new User(id,userName,note) ;
        activeMQUserService.sendUser(user);
        return result(true,user) ;
    }


    private Map<String,Object> result(Boolean success,Object message){
        Map<String,Object> retMap = new HashMap<String,Object>() ;
        retMap.put("success",success) ;
        retMap.put("message",message) ;
        return retMap ;
    }
}
