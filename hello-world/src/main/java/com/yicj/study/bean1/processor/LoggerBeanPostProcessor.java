package com.yicj.study.bean1.processor;

import com.yicj.study.bean1.common.AutoLog;
import com.yicj.study.bean1.component.AutoLoggerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class LoggerBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private AutoLoggerHandler loggerHandler ;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        AutoLog annotation = bean.getClass().getAnnotation(AutoLog.class);
        if(annotation !=null){
            return loggerHandler.getProxy(bean) ;
        }
        return bean;
    }




}
