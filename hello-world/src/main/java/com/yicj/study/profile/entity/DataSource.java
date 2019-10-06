package com.yicj.study.profile.entity;

import lombok.Data;

@Data
public class DataSource {
    private String driver ;
    private String url ;
    private String username ;
    private String password ;

    public void close(){
        System.out.println("datasource close !");
    }
}
