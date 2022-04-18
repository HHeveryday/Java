package com.nqc.calendar;

import java.util.Calendar;

/**
 * 学习使用Calendar
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //1、拿到系统此刻的日历对象
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);


        //获取日历中的某个字段信息
        int year = cal.get(Calendar.YEAR);
        System.out.println(year);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);



    }
}
