package com.yicj.study.async2;


import com.yicj.study.async2.common.AsyncProxy;
import com.yicj.study.async2.service.IHelloService;
import com.yicj.study.async2.service.impl.HelloServiceImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();
        //这个需要注意，方法返回值必须为Object，不然异步和同步调用时无法接收
        test2();
    }

    private static void test1(){
        IHelloService helloService = new HelloServiceImpl() ;
        long start = System.currentTimeMillis();
        String r1 = (String) helloService.hello();
        String r2 = (String) helloService.world();
        long end = System.currentTimeMillis();
        System.out.println("总耗时 ："+((end - start)/1000)+"秒");
        System.out.println(r1);
        System.out.println(r2);
    }

    private static void test2() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10) ;
        try {
            IHelloService helloService = new HelloServiceImpl() ;
            final IHelloService proxyService = AsyncProxy.getProxy(helloService,pool);
            long start = System.currentTimeMillis();
            Future<Object> f1 =  (Future<Object>)proxyService.hello();
            Future<Object> f2 = (Future<Object>) proxyService.world();
            String r2 = (String)f2.get();
            String r1 = (String)f1.get();
            long end = System.currentTimeMillis();
            System.out.println("共耗时 ："+((end - start)/1000)+"秒");
            System.out.println(r1);
            System.out.println(r2);
        }finally {
            pool.shutdown();
        }
    }
}
