package com.yicj.study.bean2;

import com.yicj.study.bean2.config.AppConfig;
import com.yicj.study.bean2.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class) ;
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }
}
