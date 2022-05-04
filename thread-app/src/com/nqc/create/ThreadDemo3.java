package com.nqc.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式3，使用Callable+FutureTask
 */
public class ThreadDemo3 {
    public static void main(String[] args) {

        Callable<String> call = new MyCallableDemo(100);
        FutureTask<String> f = new FutureTask<String>(call);
        Thread t1 = new Thread(f);
        t1.start();

        Callable<String> call2 = new MyCallableDemo(300);
        FutureTask<String> f2 = new FutureTask<String>(call2);
        Thread t2 = new Thread(f2);
        t2.start();

        try {
            String s1 = f.get();
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String s2 = f2.get();
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 5; i++) {
            System.out.println("主线程启动" + i);
        }
    }
}

