package com.nqc.arrylist;

import java.util.ArrayList;

/**
 * 遍历集合中的元素并删除的两种方法
 */
public class ArrayListTest4 {
    public static void main(String[] args) {
        ArrayList<Integer> score = new ArrayList<>();
        score.add(98);
        score.add(65);
        score.add(75);
        score.add(89);
        score.add(69);
        score.add(86);
//        for (int i = 0; i < score.size(); i++) {
//            if(score.get(i) < 80){
//                score.remove(i);
//                i--;//删除后必须将i减一，否则会跳过下一个元素
//            }
//        }

        //方法二，从后往前遍历集合
        for (int i = score.size() - 1; i >= 0; i--) {
            if(score.get(i) < 80){
                score.remove(i);
            }
        }
        System.out.println(score);
    }

}
