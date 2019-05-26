package com.bjl.thread.sync;

public class AccountingSyncBad implements Runnable{
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
        // 如果用一个对象，则正常
        AccountingSyncBad s1 = new AccountingSyncBad();
        //new 了2个对象，所以是2个对象的锁
        Thread t1 = new Thread(new AccountingSyncBad()); //new Thread(s1);
        Thread t2 = new Thread(new AccountingSyncBad()); //new Thread(s1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i = [" + i + "]");

    }
}
