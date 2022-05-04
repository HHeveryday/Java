package com.nqc.create;

import java.util.concurrent.Callable;

public class MyCallableDemo implements Callable<String> {
    private int n;

    public MyCallableDemo(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return "计算结果为：" + sum;
    }
}
