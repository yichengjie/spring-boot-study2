package com.yicj.study.async.controller;

import com.yicj.study.async.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
public class HelloController {

    @Autowired
    private IHelloService helloService ;

    @GetMapping("/hello")
    public String hello(){
        long start = System.currentTimeMillis() ;
        Future<String> r1 = helloService.doBusi1();
        Future<String> r2 = helloService.doBusi2();
        Future<String> r3 = helloService.doBusi3();
        while (true){
            if(r1.isDone() && r2.isDone() && r3.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis() ;
        return "hello 总耗时 : " + ( (end - start)/ 1000) ;
    }
}
