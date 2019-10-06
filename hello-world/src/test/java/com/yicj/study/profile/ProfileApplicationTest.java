package com.yicj.study.profile;

import com.yicj.study.profile.entity.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ProfileApplication.class)
@RunWith(SpringRunner.class)
public class ProfileApplicationTest {

    @Autowired
    private DataSource dataSource ;

    @Test
    public void testProfile(){
        System.out.println(dataSource);
    }
}
