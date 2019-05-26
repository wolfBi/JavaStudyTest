package com.bjl.thread.method;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTest implements Runnable{
    CompletableFuture<Integer> re = null;
    public FutureTest(CompletableFuture<Integer> re){
        this.re = re;
    }
    public void run() {
        int myre = 0 ;
        try {
            myre = re.get() * re.get();
//            study();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(myre);
    }


    /**
     *  有返回值的线程
     */
    public static void study() throws Exception {
        int taskSize = 2;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        //创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i+"");
            //执行任务并且获取 Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        //关闭线程池
        pool.shutdown();
        //获取所有并发任务的运行结果
        for (Future f : list) {
            System.out.println("res:" +f.get().toString());
        }
    }

    private static class MyCallable implements Callable {
        private String name;
        public MyCallable(String s) {
            name = s ;
        }

        @Override
        public Object call() throws Exception {
            //dosomething
            Thread.sleep(500);
            return name;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final  CompletableFuture<Integer> re = new  CompletableFuture<Integer>();
        Thread t1 = new Thread(new FutureTest(re));
        t1.start();
        Thread.sleep(1000);
        re.complete(60);
    }
}
