package com.yicj.study.future.common;

import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureResult implements Future {

    @Setter
    private Object data ;

    public void  setData(Object data) {
        synchronized (this){
            this.data = data;
            this.notify();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        synchronized (this){
            return this.data != null ;
        }
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return this.lget();
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.lget();
    }

    private Object lget() throws InterruptedException {
        synchronized (this){
            if(this.data == null){
                this.wait();
            }
            return this.data;
        }
    }
}
