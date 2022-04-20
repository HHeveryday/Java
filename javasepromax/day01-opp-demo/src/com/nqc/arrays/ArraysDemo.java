package com.nqc.arrays;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,20,6};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);//升序
        System.out.println(Arrays.toString(arr));

        //二分搜索，先排序，再查找

        int index = Arrays.binarySearch(arr,6);
        System.out.println(index);

    }
}
