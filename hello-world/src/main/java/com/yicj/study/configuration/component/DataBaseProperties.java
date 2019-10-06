package com.yicj.study.configuration.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataBaseProperties {
    @Value("${datasource.driverName}")
    private String driverName ;
    @Value("${datasource.url}")
    private String url ;
    @Value("${datasource.username}")
    private String username ;
    @Value("${datasource.password}")
    private String password ;
}
