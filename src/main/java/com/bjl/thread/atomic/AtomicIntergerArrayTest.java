package com.bjl.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntergerArrayTest {
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);
    public static class AddThread implements Runnable{
        public void run(){
            for (int i= 0 ; i < 100000 ; i++){
                arr.getAndIncrement(i%arr.length());
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
        System.out.println( arr );
        //[100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000]
    }
}
