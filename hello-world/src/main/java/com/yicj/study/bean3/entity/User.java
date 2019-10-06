package com.yicj.study.bean3.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    @Value("100")
    private Long id ;
    @Value("yicj")
    private String username ;
    @Value("note1")
    private String note ;
}
