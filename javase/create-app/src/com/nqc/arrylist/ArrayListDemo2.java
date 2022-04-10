package com.nqc.arrylist;

import java.util.ArrayList;

/**
 * 使用泛型约束ArrayList集合操作的数据类型
 */
public class ArrayListDemo2 {
    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<>(String);
        ArrayList<String> list = new ArrayList<>();//JDK1.7开始，泛型后面的类型声明可以不写
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
//        list.add(12);
//        list.add(23.5);


        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(13);
        list2.add(14);
    }
}
