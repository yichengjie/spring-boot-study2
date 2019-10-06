package com.yicj.study.bean2.config;

import com.yicj.study.bean2.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name ="user")
    public User initUser(){
        User user = new User() ;
        user.setId(100l);
        user.setUsername("yicj");
        user.setNote("note 1");
        return user ;
    }
}
