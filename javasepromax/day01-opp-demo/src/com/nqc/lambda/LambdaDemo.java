package com.nqc.lambda;


//用于简化匿名内部类
//使用要求：只能用于简化接口中只有一个抽象方法的匿名内部类形式

public class LambdaDemo {

    public static void main(String[] args) {

        Swiming s1 = new Swiming() {
            @Override
            public void swim() {
                System.out.println("测试1~~~");
            }
        };

        go(s1);

        Swiming s2 = () -> {
            System.out.println("测试2~~~");
        };
        go(s2);



//        go(() -> {
//            System.out.println("测试3~~~");
//        });

        go(() -> System.out.println("测试3~~~"));

    }



    public static void go(Swiming s){
        System.out.println("开始~~~");
        s.swim();
        System.out.println("结束~~~");
    }

}



@FunctionalInterface
interface Swiming{
    void swim();
}
