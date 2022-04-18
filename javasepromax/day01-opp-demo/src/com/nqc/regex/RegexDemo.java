package com.nqc.regex;

import java.util.Scanner;

public class RegexDemo {
    public static void main(String[] args) {
        //校验手机号码 邮箱 电话号码
        checkphone();
        checkEmail();
        checkTel();
    }

    public static void checkphone(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要校验的手机号：");
            String phone = sc.next();
            if (phone.matches("[1][3-9]\\d{9}")){
                System.out.println("格式正确，校验成功！");
                break;
            }else {
                System.out.println("格式错误，校验失败，请重新输入！");
            }
        }
    }
    public static void checkEmail(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要校验的邮箱：");
            String email = sc.next();
            if (email.matches("\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("邮箱格式正确，校验成功！");
                break;
            }else {
                System.out.println("格式错误，校验失败，请重新输入！");
            }
        }
    }

    public static void checkTel(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要校验的电话号码：");
            String tel = sc.next();
            if (tel.matches("0\\d{2,6}-?\\d{5,20}")){
                System.out.println("电话格式正确，校验成功！");
                break;
            }else {
                System.out.println("格式错误，校验失败，请重新输入！");
            }
        }
    }

}
