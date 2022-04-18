package com.nqc.date.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将得到的时间值格式化为喜欢的样式
 */
public class SimpleDateFormatDemo1 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String t1 = sdf.format(d);
        System.out.println(t1);
        String t2 = sdf.format(System.currentTimeMillis());
        System.out.println(t2);
    }
}
