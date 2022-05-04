package com.nqc.peoxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarAgentProxy {
    //设计一个方法返回一个明星对象的代理对象。

    public static Skill getProxy(Star obj){


        //为明星对象生产一个代理对象
        /**
         *     public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h) {
         */

        return (Skill) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("进行准备工作~~~");
                //method调用的方法对象，args代表这个方法的参数
                Object rs = method.invoke(obj,args);
                System.out.println("进行收尾工作~~~~");
                return rs;
            }
        });
    }
}
