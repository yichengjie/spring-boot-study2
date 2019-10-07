package com.yicj.study.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync//@EnableAsync  注解主要是为了扫描范围包下的所有 @Async注解
//注意这里只能扫描当前包及其子包下的@Async注解
public class AsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class,args) ;
    }
}
