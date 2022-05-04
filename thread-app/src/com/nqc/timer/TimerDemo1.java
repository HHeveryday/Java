package com.nqc.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
    public static void main(String[] args) {
        //1、创建定时器
        Timer timer = new Timer();
        //2、调用方法，处理定时任务

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了一次");
            }
        }, 3000, 2000);
    }
}
