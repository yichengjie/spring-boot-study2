package com.yicj.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//响应中断的例子
public class LockInterruptiblyDemo {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask(lock1,lock2),"线程1");
        Thread t2 = new Thread(new MyTask(lock2,lock1),"线程2") ;
        t1.start();
        t2.start();
        t1.interrupt();//第一个线程中断
    }


    static class MyTask implements Runnable {
        private Lock firstLock;
        private Lock secondLock;

        public MyTask(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                //停一下更好的触发死锁
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() +"正常结束");
            }
        }
    }


}

