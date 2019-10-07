package com.yicj.study.async.service;

import java.util.concurrent.Future;

public interface IHelloService {
    Future<String> doBusi1() ;

    Future<String> doBusi2() ;

    Future<String> doBusi3() ;
}
