package com.yicj.study.bean1;

import com.yicj.study.bean1.service.IAutoLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PostProcessorApplication.class)
@RunWith(SpringRunner.class)
public class AutoLogServiceTest {

    @Autowired
    private IAutoLogService autoLogService ;

    @Test
    public void testHello(){
        autoLogService.sayHello("yicj");
    }
}
