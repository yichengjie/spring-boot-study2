package com.yicj.study.bean1.service.impl;

import com.yicj.study.bean1.common.NameInit;
import com.yicj.study.bean1.service.IHelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService , NameInit {

    private String name ;

    @Override
    public void sayHello() {
        System.out.println("hello " + name);
    }

    @Override
    public void setName(String name) {
        this.name = name ;
    }
}
