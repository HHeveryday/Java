package com.nqc.create;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程启动" + i);
        }
    }
}
