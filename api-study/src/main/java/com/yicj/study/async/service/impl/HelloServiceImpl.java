package com.yicj.study.async.service.impl;

import com.yicj.study.async.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class HelloServiceImpl implements IHelloService {

    @Override
    @Async
    public Future<String> doBusi1() {
        log.info("do busi1 ......");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("error:",e);
        }
        return new AsyncResult<String>("业务1执行完成！");
    }

    @Override
    public Future<String> doBusi2() {
        log.info("do busi2 ......");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            log.error("error:",e);
        }
        return new AsyncResult<String>("业务2执行完成！");
    }

    @Override
    public Future<String> doBusi3() {
        log.info("do busi3 ......");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("error:",e);
        }
        return new AsyncResult<String>("业务2执行完成！");
    }
}
