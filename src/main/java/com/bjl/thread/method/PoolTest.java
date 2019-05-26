package com.bjl.thread.method;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest implements Runnable {
    @Override
    public void run() {
        int taskSize = 10;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        while (true){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is running...");
                    try{
                        Thread.sleep(3000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        //看好你的CPU!!!
        Thread t1 = new Thread(new PoolTest());
        t1.start();
    }
}
