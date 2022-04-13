package com.nqc.d3_static_singleinstance;

/**
 * 饿汉单例实现单例类
 */
public class SingleInstance {

    //2、饿汉单例是在获取对象前，对象就已经准备好了一个
    //这个对象只能是一个，所以必须定义静态成员变量

    public static SingleInstance instance = new SingleInstance();

    //1、构造器私有
    private SingleInstance(){
    }
}
