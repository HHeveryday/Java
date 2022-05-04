package com.nqc.thread_synchronized_method.thread_synchronized_lock.thread_synchronized_code;

public class Test {
    public static void main(String[] args) {
        Account acc = new Account(100000.0);
        new DrawThread("小明",acc).start();
        new DrawThread("小红",acc).start();


    }
}
