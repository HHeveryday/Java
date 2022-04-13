package com.nqc.d1_static;

public class User {
    /**
     * 在线人数
     * 注意：static修饰的成员变量：静态成员变量，只在内存中有一份，可以被共享
     */
    public static int onlineNumber;
    private String name;
    private int age;


    public static void main(String[] args) {
        User u = new User();
        System.out.println(User.onlineNumber);
        System.out.println(u.onlineNumber);
        //User.name//报错  对象名.实例成员变量

        //同一类中静态成员变量的访问可以省略类名
        System.out.println(onlineNumber);
    }
}
