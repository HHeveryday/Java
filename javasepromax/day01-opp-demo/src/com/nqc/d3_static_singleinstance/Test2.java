package com.nqc.d3_static_singleinstance;

public class Test2 {
    public static void main(String[] args) {
        SingleInstance2 instance1 = SingleInstance2.getInstance();
        SingleInstance2 instance2 = SingleInstance2.getInstance();
        System.out.println(instance1 == instance2);
    }
}
