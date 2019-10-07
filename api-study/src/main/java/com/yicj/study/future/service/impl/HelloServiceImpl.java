package com.yicj.study.future.service.impl;

import com.yicj.study.future.common.FutureResult;
import com.yicj.study.future.service.IHelloService;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class HelloServiceImpl implements IHelloService  {
    @Override
    public Future doBusi1() {
        FutureResult result = new FutureResult() ;
        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
                result.setData("执行完业务1花费3秒钟...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start(); ;
        return result;
    }

    @Override
    public Future doBusi2() {
        FutureResult result = new FutureResult() ;
        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(2);
                result.setData("执行完业务2花费2秒钟...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return result;
    }
}
