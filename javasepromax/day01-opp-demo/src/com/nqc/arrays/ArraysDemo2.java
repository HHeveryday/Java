package com.nqc.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,20,6};

        Arrays.sort(arr);//默认升序
        System.out.println(Arrays.toString(arr));

        //修改排序规则，需要引用类型
        Integer[] arr2 = {1,2,3,4,5,20,6};
        //默认升序排序规则：o1比o2大返回正整数，小则返回负整数，相等返回年龄
        //改写比较规则，使用Comparator比较器对象
        Arrays.sort(arr2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr2));


        Student[] student = new Student[3];
        student[0] = new Student("测试",21,175.6);
        student[1] = new Student("测试2",19,180.6);
        student[2] = new Student("测试3",25,179.5);

        //按年龄升序排序

        Arrays.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(Arrays.toString(student));

        //按年龄降序排序

        Arrays.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        System.out.println(Arrays.toString(student));

        //按身高降序排序

        Arrays.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getHeight(), o1.getHeight());
            }
        });

        System.out.println(Arrays.toString(student));
    }
}

