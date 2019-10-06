package com.yicj.study.bean1;

import com.yicj.study.bean1.service.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostProcessorApplication.class)
public class PostProcessorApplicationTest {

    @Autowired
    private IHelloService helloService ;

    @Test
    public void testHello(){
        helloService.sayHello();
    }
}
