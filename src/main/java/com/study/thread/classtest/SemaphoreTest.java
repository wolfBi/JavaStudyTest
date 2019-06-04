package com.study.thread.classtest;

import java.util.concurrent.Semaphore;

/**
 * 用来构建池
 * 控制同时访问的线程个数
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //8个工人使用5个机器
        int n = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < n; i++) {
            new Worker(i,semaphore).start();
        }
        //工人3占用了一个机器在生产。。。
        //工人1占用了一个机器在生产。。。
        //工人0占用了一个机器在生产。。。
        //工人7占用了一个机器在生产。。。
        //工人4占用了一个机器在生产。。。
        //工人3释放机器。。。
        //工人2占用了一个机器在生产。。。
        //工人1释放机器。。。
        //工人4释放机器。。。
        //工人5占用了一个机器在生产。。。
        //工人0释放机器。。。
        //工人7释放机器。。。
        //工人6占用了一个机器在生产。。。
        //工人2释放机器。。。
        //工人5释放机器。。。
        //工人6释放机器。。。
    }
    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker (int num, Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try{
                //申请许可
                semaphore.acquire();

                try{
                    System.out.println("工人"+this.num+"占用了一个机器在生产。。。");
                    Thread.sleep(2000);
                    System.out.println("工人"+this.num+"释放机器。。。");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //释放许可
                    semaphore.release();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
