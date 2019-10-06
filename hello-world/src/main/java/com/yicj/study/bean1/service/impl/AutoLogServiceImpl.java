package com.yicj.study.bean1.service.impl;

import com.yicj.study.bean1.common.AutoLog;
import com.yicj.study.bean1.service.IAutoLogService;
import org.springframework.stereotype.Service;

@Service
@AutoLog //可以对方法记录日志
public class AutoLogServiceImpl implements IAutoLogService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
