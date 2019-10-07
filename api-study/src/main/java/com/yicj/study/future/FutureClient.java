package com.yicj.study.future;

public class FutureClient {

    public Data request(String queryStr){
        //一个代理对象(Data接口的实现类)先返回给发送请求的客户端，告诉他请求已收到，可以做其他的事
        FutureData futureData = new FutureData() ;
        //启动一个新的线程，去加载真实的数据,传给这个代理对象
        new Thread(()->{
            //这个新的线程可以去慢慢加载真实对象，然后传递给代理对象
            RealData realData = new RealData(queryStr) ;
            futureData.setRealData(realData);
        }).start();
        return futureData ;
    }

}
