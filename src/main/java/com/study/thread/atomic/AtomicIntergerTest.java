package com.study.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntergerTest {
    static AtomicInteger in = new AtomicInteger();
    public static class AddThread implements Runnable{
        public void run(){
            for (int i= 0 ; i < 10000 ; i++){
                in.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new Thread(new AddThread());
        }
        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }
        for (int i = 0; i < 10; i++) {
            ts[i].join();
        }
        System.out.println("args = [" + in + "]");
        //args = [100000]
    }
}
