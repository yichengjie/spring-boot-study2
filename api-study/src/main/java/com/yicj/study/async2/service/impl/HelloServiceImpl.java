package com.yicj.study.async2.service.impl;

import com.yicj.study.async2.service.IHelloService;
import java.util.concurrent.TimeUnit;

public class HelloServiceImpl implements IHelloService {

    @Override
    public Object hello() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @Override
    public Object world() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "world";
    }
}
