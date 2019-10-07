package com.yicj.study.async2.common;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;

public class AsyncProxy{

    //Object target,ExecutorService executorService
    public static <T> T getProxy(T target, ExecutorService executorService) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new AsyncInvocationHandler(target,executorService)
        ) ;
    }
}
