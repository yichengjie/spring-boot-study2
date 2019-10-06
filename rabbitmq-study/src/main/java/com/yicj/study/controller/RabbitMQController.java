package com.yicj.study.controller;

import com.yicj.study.entity.User;
import com.yicj.study.service.IRabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    @Autowired
    private IRabbitMQService rabbitMQService ;

    @GetMapping("/msg")
    public Map<String,Object> msg(String message){
        rabbitMQService.sendMsg(message) ;
        return result(true,message) ;
    }

    @GetMapping("/user")
    public Map<String,Object> user(Long id, String userName){
        User user = new User(id,userName) ;
        rabbitMQService.sendUser(user);
        return result(true,user) ;
    }

    private Map<String,Object> result(Boolean success,Object message){
         Map<String,Object> retMap = new HashMap<String, Object>() ;
         retMap.put("success",success) ;
         retMap.put("message",message) ;
         return retMap ;
    }
}
