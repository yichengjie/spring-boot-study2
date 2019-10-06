package com.yicj.study.configuration;

import com.yicj.study.configuration.component.DataBaseProperties;
import com.yicj.study.configuration.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyConfigurationApplication {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class) ;
        DataBaseProperties properties = ctx.getBean(DataBaseProperties.class);
        System.out.println(properties);
    }
}
