package com.bjl.thread.classtest;

import java.util.concurrent.CyclicBarrier;

/**
 * 回环栅栏-等到至Barrier状态再同时执行
 * 让一组线程等待到某一状态时再全部同时执行
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int n = 4;
        CyclicBarrier barrier = new CyclicBarrier(n);
        for (int i = 0; i < n; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier =cyclicBarrier;
        }

        @Override
        public void run() {
            try{
                //以睡眠来模拟线程需要预定写入数据操作
                Thread.sleep(5000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"所有线程写入数据完毕，继续处理其他任务");
        }
    }
}
