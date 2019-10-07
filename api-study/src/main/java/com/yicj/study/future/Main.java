package com.yicj.study.future;

public class Main {

    public static void main(String[] args) {
        FutureClient client = new FutureClient() ;
        Data data = client.request("test");
        String result = data.getRequest();
        System.out.println(result);
    }
}
