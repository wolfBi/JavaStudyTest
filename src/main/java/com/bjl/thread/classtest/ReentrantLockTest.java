package com.bjl.thread.classtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private Lock lock = new ReentrantLock();
    //Lock classtest = new ReentrantLock(true);//公平锁
    //Lock classtest = new ReentrantLock(false);//非公平锁

    private Condition condition = lock.newCondition();

    public void testMethod(){
        try{
            lock.lock();
            //1 wait方法等待
            System.out.println("开始等待 wait");
            condition.wait();   //java.lang.IllegalMonitorStateException
            //通过创建condition 对象来使线程wait,必须先执行 classtest.classtest()方法获得锁

            //2 signal方法唤醒
            condition.signal();
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread Name = "+Thread.currentThread().getName()+" "+(i+1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        test.testMethod();
    }

}
