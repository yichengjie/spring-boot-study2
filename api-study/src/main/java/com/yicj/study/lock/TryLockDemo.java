package com.yicj.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {


    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();


    public static void main(String[] args) {
        Thread thread = new Thread(new MyTask(lock1, lock2));//该线程先获取锁1,再获取锁2
        Thread thread1 = new Thread(new MyTask(lock2, lock1));//该线程先获取锁2,再获取锁1
        thread.start();
        thread1.start();
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
                while (!firstLock.tryLock()){
                    TimeUnit.MILLISECONDS.sleep(10);
                }
                //说明获取到锁1
                while (!secondLock.tryLock()){
                    firstLock.unlock();
                    TimeUnit.MILLISECONDS.sleep(10);
                }
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
