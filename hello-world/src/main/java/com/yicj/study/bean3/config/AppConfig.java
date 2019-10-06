package com.yicj.study.bean3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yicj.study.bean3")
//ComponentScan默认只会扫描当前包及其子包
public class AppConfig {

}
