package com.study.thread.sync;

public class AccountingSyncClass implements Runnable{
    static int i = 0;
    //static 方法，是class的
    public synchronized static void increase(){
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
        //静态static 方法属于类class的 所以new的对象也没用
        Thread t1 = new Thread(new AccountingSyncClass()); //new Thread(s1);
        Thread t2 = new Thread(new AccountingSyncClass()); //new Thread(s1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i = [" + i + "]");//20000000

    }
}
