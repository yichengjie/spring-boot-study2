package com.yicj.study.bean1.config;

import com.yicj.study.bean1.processor.NameBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {

    @Bean
    public NameBeanPostProcessor nameBeanPostProcessor(){
        NameBeanPostProcessor processor = new NameBeanPostProcessor() ;
        processor.setName("yicj");
        return processor ;
    }
}
