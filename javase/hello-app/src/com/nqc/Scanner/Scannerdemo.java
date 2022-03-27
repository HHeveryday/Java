package com.nqc.Scanner;

import java.util.Scanner;

public class Scannerdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("姓名："+name+"年龄:"+age);
    }
}
