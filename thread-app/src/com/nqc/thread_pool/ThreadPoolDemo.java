package com.nqc.thread_pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        /**
         *     public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler)
         */
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 7, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Runnable t = new MyRunnable();
        //核心的三个线程
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);

        //任务队列等待的5个任务
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);

        //当核心线程没空，任务队列已满，则会创建临时线程
        pool.execute(t);
        pool.execute(t);

        //大于最大的线程池数量，拒绝策略被触发
        pool.execute(t);


    }
}
