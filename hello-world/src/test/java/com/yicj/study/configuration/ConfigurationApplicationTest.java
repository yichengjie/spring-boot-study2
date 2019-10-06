package com.yicj.study.configuration;

import com.yicj.study.configuration.component.DataBaseProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ConfigurationApplication.class)
@RunWith(SpringRunner.class)
public class ConfigurationApplicationTest {

    @Autowired
    private DataBaseProperties properties ;

    @Test
    public void testHello(){
        System.out.println("==========> " + properties);
    }
}
