package com.nqc.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerDemo2 {
    public static void main(String[] args) {
        //1、创建定时器ScheduledExecutorService
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(3);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "AAA执行输出--》" + new Date());
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);



        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "BBB执行输出--》" + new Date());
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
