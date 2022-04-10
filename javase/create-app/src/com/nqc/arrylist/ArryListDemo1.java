package com.nqc.arrylist;

import java.util.ArrayList;

public class ArryListDemo1 {
    public static void main(String[] args) {
        //创建ArrayList集合对象
        ArrayList list = new ArrayList();
//添加数据
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        list.add("测试4");
        list.add(10);

        System.out.println(list);

        //指定位置添加数据

        list.add(3,22.5);
        System.out.println(list);

    }
}
