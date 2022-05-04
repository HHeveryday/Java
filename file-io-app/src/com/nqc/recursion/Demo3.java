package com.nqc.recursion;

/**
 * 买啤酒问题，2元一瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶
 * 10元可以换多少啤酒，还剩多少瓶子和盖子
 */
public class Demo3 {
    public static int toltalNumber;
    public static int lastCoverNumber;
    public static int lastBottleNumber;

    public static void main(String[] args) {
        buy(10);
        System.out.println(toltalNumber);
        System.out.println(lastBottleNumber);
        System.out.println(lastCoverNumber);
    }


    private static void buy(int money) {
        //1、记录本轮的数量
        lastBottleNumber += money / 2;
        lastCoverNumber += money / 2;
        //2、计算总的数量
        toltalNumber += money / 2;

        //3、计算可以兑换的钱
        int money1 = 0;
        if (lastCoverNumber >=4){
            money1 += lastCoverNumber / 4 * 2;
            lastCoverNumber %= 4;
        }
        if (lastBottleNumber >= 2){
            money1 += lastBottleNumber / 2 * 2;
            lastBottleNumber %= 2;
        }

        //4、递归购买
        if (money1 >= 2){
            buy(money1);
        }

    }
}
