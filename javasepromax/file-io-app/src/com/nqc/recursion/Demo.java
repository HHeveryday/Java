package com.nqc.recursion;

/**
 * 猴子吃桃问题：第一天摘下若干个桃子，之后每一天都吃前一天的一半再多吃一个
 * f(n) - f(n)/2 - 1= f(n + 1)
 * f(n) = 2*f(n + 1) + 2
 * f(10) = 1
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(fun(1));
        System.out.println(fun(2));
        System.out.println(fun(3));
    }

    private static int fun(int n) {
        if (n == 10){
            return 1;
        }else {
            return 2 * fun(n + 1) + 2;
        }
    }
}
