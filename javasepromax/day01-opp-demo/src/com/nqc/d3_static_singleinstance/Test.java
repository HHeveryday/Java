package com.nqc.d3_static_singleinstance;

public class Test {
    public static void main(String[] args) {
        SingleInstance instance1 = SingleInstance.instance;
        SingleInstance instance2 = SingleInstance.instance;
        System.out.println(instance1 == instance2);
    }
}
