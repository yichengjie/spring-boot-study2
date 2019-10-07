package com.yicj.study.async2.service.common;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncProxy {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10) ;
    //Object target,ExecutorService executorService
    public static Object getProxy(Object target) {
        return  Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new AsyncInvocationHandler(target,executorService)
        ) ;
    }
}
