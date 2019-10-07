package com.yicj.study.future;

import com.yicj.study.future.service.IHelloService;
import com.yicj.study.future.service.impl.HelloServiceImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        IHelloService helloService = new HelloServiceImpl() ;
        long start = System.currentTimeMillis() ;
        Future f1 = helloService.doBusi1();
        Future f2 = helloService.doBusi2();
        while (true){
            if(f1.isDone() && f2.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis() ;
        System.out.println("总耗时: " + ((end - start)/1000) +"秒");
        Object r1 = f1.get();
        Object r2 = f2.get();
        System.out.println("r1返回：" + r1);
        System.out.println("r2返回：" + r2);
        System.out.println("主方方法执行完...");
    }
}
