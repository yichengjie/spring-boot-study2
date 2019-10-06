package com.yicj.study.bean1.component;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
@Component
public class AutoLoggerHandler implements InvocationHandler {
        @Setter
        private Object target ;

        public Object getProxy(Object target){
           this.target = target ;
           return  Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    this) ;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("method [{}] execute start.... ",method.getName());
            long start = System.currentTimeMillis();
            Object retObj = method.invoke(target, args);
            long end = System.currentTimeMillis() ;
            log.info("take time {}s", (end - start)/1000 );
            log.info("method [{}] execute end.... ",method.getName());
            return retObj;
        }
    }