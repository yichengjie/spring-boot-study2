package com.yicj.study.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    private int size ; //阻塞队列的最大容量
    private ReentrantLock lock = new ReentrantLock() ;
    LinkedList<E> list = new LinkedList<E>() ;//队列底层实现
    Condition fullCondition = lock.newCondition() ; //队列满时的等待条件
    Condition emptyCondition = lock.newCondition() ; //队列空时的等待条件

    public MyBlockingQueue(int size) {
        this.size = size ;
    }

    public void enqueue(E e) throws InterruptedException {

        lock.lock();
        try {
            //队列已满，在fullCondition条件上等待
            while (list.size() ==size){
                fullCondition.await();
            }
            list.add(e) ;//入队,加入链表末端
            System.out.println("入队 :" +e);
            //通知在emptyCondition条件上等待的线程
            emptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e ;
        lock.lock();
        try {
            //队列为空，在emptyCondition条件上等待
            while (list.size() == 0){
                emptyCondition.await();
            }
            //出队:移除链表首元素
            e = list.removeFirst() ;
            System.out.println("出队：" + e);
            //通知在 fullCondition条件上等待的线程
            fullCondition.signal();
            return e ;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2) ;
        for (int i = 0 ; i < 10 ; i ++){
            int data = i ;
            new Thread(()->{
                try {
                    queue.enqueue(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start(); ;
        }

        for (int i = 0 ; i < 10 ; i ++){
            new Thread(()->{
                try {
                    Integer data = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start(); ;
        }


    }

}
