package com.nqc.peoxy;

/**
 * 开发动态代理的对象，理解动态代理的执行流程
 */

public class Test {
    public static void main(String[] args) {
        //创建一个对象，其对象的类必须实现接口
        Star star = new Star("杨超越");
        //为杨超越生成一个代理对象
        Skill s = StarAgentProxy.getProxy(star);
        s.dance();
        s.sing();

    }
}
