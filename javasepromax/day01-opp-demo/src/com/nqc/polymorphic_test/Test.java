package com.nqc.polymorphic_test;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer("华为");

        USB u1 = new KeyBoard("cherry");
        USB u2 = new Mouse("罗技");
        computer.start();
        computer.run(u1);
        computer.run(u2);

    }
}
