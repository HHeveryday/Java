package com.nqc.date.data;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        //计算当前时间往后走1小时79秒
        long time = date.getTime();
        long time2 = time + (60 * 60 + 79) * 1000;

        Date date1 = new Date();
        date1.setTime(time2);
        System.out.println(date1);
    }
}
