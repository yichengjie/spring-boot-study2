package com.yicj.study.future;

import java.util.concurrent.TimeUnit;

public class RealData implements Data {
    private String result ;
    public RealData(String queryStr){
        try {
            TimeUnit.SECONDS.sleep(3);
            this.result = "返回查询数据" ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRequest() {
        return this.result;
    }
}
