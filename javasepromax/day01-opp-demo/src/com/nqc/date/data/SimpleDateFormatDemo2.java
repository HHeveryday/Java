package com.nqc.date.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用SimpleDateFormat解析时间
 */
public class SimpleDateFormatDemo2 {
    public static void main(String[] args) throws ParseException {
        //计算2022年11月12日 11:25:03往后3天15小时5分6秒的日期
        //1、将要解析的日期存放在字符串中
        String date = "2022年11月12日 11:25:03";
        //2、确定解析的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //3、解析日期
        Date d1 = sdf.parse(date);
        //4、计算时间
        long time = d1.getTime() + (3L * 24 * 60 * 60 + 15 * 60 * 60 + 5 * 60 + 6) * 1000;

        //5、再将得到的毫秒时间格式化
        System.out.println(sdf.format(time));
    }
}
