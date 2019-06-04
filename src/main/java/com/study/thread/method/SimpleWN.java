package com.study.thread.method;

public class SimpleWN  {
    public static Object object = new Object();
    public static class T1 extends Thread{
        public void run(){
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T1 start!");
                try{
                    System.out.println(System.currentTimeMillis()+":T1 wait!");
                    object.wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T1 end!");
            }
        }
    }
    public static class T2 extends Thread{
        public void run(){
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T2 start! notify ");
                object.notify();
                System.out.println(System.currentTimeMillis()+":T2 end!");
                try{
                   Thread.sleep(2000);
                }catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
        //1556540149029:T1 start!
        //1556540149029:T1 wait!
        //1556540149030:T2 start! notify
        //1556540149030:T2 end!
        //1556540151030:T1 end!
    }
}
