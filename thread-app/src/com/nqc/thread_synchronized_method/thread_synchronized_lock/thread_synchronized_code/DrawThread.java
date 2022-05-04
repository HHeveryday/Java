package com.nqc.thread_synchronized_method.thread_synchronized_lock.thread_synchronized_code;

public class DrawThread extends Thread{
    private Account acc;
    public DrawThread(String name, Account acc){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run() {
        acc.DrawMoney(100000);
    }
}
