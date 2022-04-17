package com.nqc.polymorphic_test;

public class KeyBoard implements USB{
    private String name;

    public KeyBoard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void Istall() {
        System.out.println(name + "与电脑连接成功！！！");
    }

    @Override
    public void Unistall() {
        System.out.println(name + "已经从电脑拔出！！！");
    }

    /**
     * 私有方法
     */
    public void onclick(){
        System.out.println(name + "正在打字！！！");
    }
}
