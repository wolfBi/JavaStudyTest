package com.bjl.thread.queue;

import java.util.Comparator;
import java.util.concurrent.*;

public class QueueTest {
    public static void main(String[] args) {
        //公平非公平，数组结构组成的有界阻塞队列  先进先出IFIO
        ArrayBlockingQueue fairQueue = new ArrayBlockingQueue(1000,true);
        //两个独立锁提高并发 对生产者消费者分别采用独立锁来控制数据同步   默认容量Integer.MAX_VALUE
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        // compareTo 排序实现优先
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        priorityBlockingQueue = new PriorityBlockingQueue(5, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });
        // 缓存失效，定时任务
        DelayQueue delayQueue = new DelayQueue();

        //链表结构组成的双向阻塞队列
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();






    }
}
