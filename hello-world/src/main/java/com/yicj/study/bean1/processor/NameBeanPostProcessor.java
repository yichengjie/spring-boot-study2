package com.yicj.study.bean1.processor;

import com.yicj.study.bean1.common.NameInit;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class NameBeanPostProcessor implements BeanPostProcessor {
    @Setter
    private String name ;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        this.execute(bean,beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    //这部分放在postProcessBeforeInitialization或则postProcessAfterInitialization里面都行
    private void execute(Object bean, String beanName){
        //如果bean为NameInit的子类
        if(NameInit.class.isAssignableFrom(bean.getClass())){
            ((NameInit)bean).setName(this.name); ;
        }
    }
}
