package com.bjl.thread.classtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 implements Runnable{
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest1 test = new ReentrantLockTest1();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try{
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println("获取锁");
                Thread.sleep(6000); //改成4000 多个线程就不会影响
            }else{
                System.out.println("获取锁失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
