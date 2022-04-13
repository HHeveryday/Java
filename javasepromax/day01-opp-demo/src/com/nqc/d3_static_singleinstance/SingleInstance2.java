package com.nqc.d3_static_singleinstance;

/**
 * 懒汉单例实现单例类
 */
public class SingleInstance2 {

    //2、定义静态成员变量，最好私有化，只能通过调用方法使用
    private static SingleInstance2 instance;

    //1、构造器私有
    private SingleInstance2(){
    }

    //3、提供一个方法，对外返回单例

    public static SingleInstance2 getInstance() {
        if (instance == null){
            instance = new SingleInstance2();
        }
        return instance;
    }
}
