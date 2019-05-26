package com.bjl.thread.sync;

public class AccountingSync2 implements Runnable{
    static AccountingSync2 instance = new AccountingSync2();
    static int i = 0;
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            /* 实例方法上的同步，因为方法不是static */
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //静态 的 instannce
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i = [" + i + "]");//20000000
    }
}
