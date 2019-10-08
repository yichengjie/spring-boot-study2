package com.yicj.study.hello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

    @GetMapping("/")
    public String  hello(){
        return "hello world" ;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args) ;
    }
}
