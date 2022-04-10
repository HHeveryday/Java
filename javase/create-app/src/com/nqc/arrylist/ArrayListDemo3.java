package com.nqc.arrylist;

import java.util.ArrayList;

/*
ArrayList常用API
 */
public class ArrayListDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        list.add("测试4");
        list.add("测试5");
        //返回指定索引出的元素
        System.out.println(list.get(2));
        //返回集合中的元素个数
        System.out.println(list.size());
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //根据索引删除，并删除的元素
        System.out.println(list.remove(2));
        System.out.println(list);

        //直接根据元素名进行删除，返回是否成功,当存在多个时，只删除第一个
        System.out.println(list.remove("测试5"));
        System.out.println(list);

        //修改指定索引出的元素
        list.set(2,"修改");
        System.out.println(list);
    }
}
