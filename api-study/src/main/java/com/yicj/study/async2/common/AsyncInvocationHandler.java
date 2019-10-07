package com.yicj.study.async2.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class AsyncInvocationHandler implements InvocationHandler {
    private ExecutorService executorService ;
    private Object target ;

    public AsyncInvocationHandler(Object target,ExecutorService executorService){
        this.target = target ;
        this.executorService = executorService ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return this.executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Object retObj = method.invoke(target, args);
                return retObj;
            }
        }) ;
    }
}
