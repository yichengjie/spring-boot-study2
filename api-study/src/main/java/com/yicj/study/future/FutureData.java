package com.yicj.study.future;

public class FutureData implements Data {

    private Data realData ;

    @Override
    public synchronized String getRequest() {
        if(this.realData == null){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.getRequest();
    }


    public synchronized void setRealData(Data realData){
        this.realData = realData;
        this.notify();
    }
}
