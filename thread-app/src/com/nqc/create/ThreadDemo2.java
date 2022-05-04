package com.nqc.create;

/**
 * 创建线程的方式2，使用Runnable
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程启动" + i);
        }
    }
}
