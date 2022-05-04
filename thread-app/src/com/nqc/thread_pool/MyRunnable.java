package com.nqc.thread_pool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行了-->" + i);
        }
        System.out.println(Thread.currentThread().getName() + "与任务绑定，进入休眠！");
        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
