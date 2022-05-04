package com.nqc.create;

/**
 * 创建线程的方式2，使用Runnable
 */
public class ThreadDemo2Other {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程1启动" + i);
                }
            }
        };
        Thread t = new Thread(r);
        t.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程2启动" + i);
                }
            }
        }).start();

        new Thread(() ->{
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程3启动" + i);
                }
        }).start();


        for (int i = 0; i < 5; i++) {
            System.out.println("主线程启动" + i);
        }
    }
}
