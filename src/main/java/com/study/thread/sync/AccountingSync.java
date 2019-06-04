package com.study.thread.sync;

public class AccountingSync implements Runnable{
    static AccountingSync instance = new AccountingSync();
    static int i = 0;

    public void run() {
        for (int j = 0; j < 10000000; j++) {
            /* 实例上的同步 */
            synchronized (instance){
                i++;
            }

            /* 验证不同步时，线程冲撞 */
//                i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i = [" + i + "]");//20000000
    }
}
