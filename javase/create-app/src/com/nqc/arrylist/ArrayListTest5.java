package com.nqc.arrylist;

import java.util.ArrayList;

public class ArrayListTest5 {
    public static void main(String[] args) {
        Movie m1 =new Movie("《肖申克的救赎》",9.7,"罗宾斯");
        Movie m2 =new Movie("《霸王别姬》",9.7,"张国荣、张丰毅");
        Movie m3 =new Movie("《阿甘正传》",9.5,"汤姆.汉克斯");

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        //遍历集合中自定义类型中的元素
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println("电影名称：" + m.getName());
            System.out.println("电影得分：" + m.getScore());
            System.out.println("电影主演：" + m.getActor());
            System.out.println("----------------------------");
        }
    }
}
