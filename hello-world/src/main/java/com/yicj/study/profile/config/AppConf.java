package com.yicj.study.profile.config;

import com.yicj.study.profile.entity.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConf {

    @Bean(name = "dataSource", destroyMethod = "close")
    @Profile("dev")
    public DataSource getDevDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc://mysql://localhost:3306/dev_ssmdemo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource ;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Profile("test")
    public DataSource getTestDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc://mysql://localhost:3306/test_ssmdemo");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource ;
    }
}
