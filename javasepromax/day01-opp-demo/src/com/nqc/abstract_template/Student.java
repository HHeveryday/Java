package com.nqc.abstract_template;

/**
 * 模板方法设计模式
 */
public abstract class Student {
    public final void write(){
        System.out.println("第一段相同内容");
        writemain();
        System.out.println("最后一段相同内容");
    }

    public abstract void writemain();
}
