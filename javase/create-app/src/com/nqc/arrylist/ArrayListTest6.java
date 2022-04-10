package com.nqc.arrylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest6 {
    public static void main(String[] args) {
        //定义学生类
        //创建学生类，封装学生信息
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("2019654231","测试1",20,"一班"));
        students.add(new Student("2019659876","测试2",21,"二班"));
        students.add(new Student("2019695324","测试3",19,"三班"));

        System.out.println("学号" + "\t"+ "姓名" + "\t"+ "年龄" + "\t" +"班级");
        //遍历
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getClassname());
        }

        //定义方法完成搜索功能
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入要查询学生的学号：");
            String id = sc.next();

            //调用方法

            Student s = getStudentById(students,id);
            if(s == null){
                System.out.println("查无此人！");
            }else {
                System.out.println("查询的信息如下：");
                System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getClassname());
            }
        }

    }

    /**
     * 根据学生的学号查询对象返回。
     * @param students 存储全部学生对象的集合
     * @param id 搜索学生的学号
     * @return 学生对象|null
     */
    public static Student getStudentById(ArrayList<Student> students, String id){
        //遍历全部学生信息
        for (int i = 0; i < students.size(); i++) {
            //判断当前学生是否为要查找的学生
            Student s = students.get(i);
            if(s.getId().equals(id)){
                //说明当前学生对象为要查找的学生
                return s;
            }
        }
        return null;
    }
}
