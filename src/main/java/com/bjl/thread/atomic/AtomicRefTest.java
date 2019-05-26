package com.bjl.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefTest {
    final static AtomicReference<String> in = new AtomicReference("abc");

    /**
     * 只有第一个能用
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final int num = i;
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int)Math.random()*100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(in.compareAndSet("abc","def")){
                        System.out.println(Thread.currentThread().getId()+" 修改了值");
                    }else{
                        System.out.println(Thread.currentThread().getId()+" 修改失败");
                    }
                }
            }.start();
        }
    }
}
