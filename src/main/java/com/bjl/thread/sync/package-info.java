package com.bjl.thread.sync;
/**
 * java核心知识点整理.pdf 4.1.9
 *  乐观锁，读多写少，写的时候才验证上锁，利用版本号，状态码，时间戳
 *  悲观锁，写多，并发写可能性高，读的时候就上锁
 *  自旋锁，
 *  synchronized 是独占式悲观锁，同时属于可重入锁
 *  ReentrantLock 除了完成synchronized工作外，还提供了可响应中断锁，可轮询请求，定时锁等避免多线程死锁的方法
 **/