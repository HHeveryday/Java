package com.nqc.sort_binarysearch;

public class Test2 {

    public static void main(String[] args) {
        int[] arr = {10, 20, 26 , 28, 35, 48, 68, 87};
        int index = binarysearch(arr,68);
        int index1 = binarysearch(arr,264);
        if (index != -1){
            System.out.println("找到了,要查找元素的下标为：" + index);
        }else {
            System.out.println("没有找到！");
        }
        if (index1 != -1){
            System.out.println("找到了,要查找元素的下标为：" + index1);
        }else {
            System.out.println("没有找到！");
        }
    }

    /**
     * 二分查找
     * @param arr 排序好的数组
     * @param data 要查找的数据
     * @return 要查找数据的索引，没有找到则返回负一
     */
    public static int binarysearch(int[] arr, int data){
        int left = 0;
        int right = arr.length - 1;

        //查找条件，左索引要小于等于右索引
        while (left <= right){
            int midlleIndex = (left + right) / 2;
            if (arr[midlleIndex] < data){
                left = midlleIndex + 1;
            }else if (arr[midlleIndex] > data){
                right = midlleIndex - 1;
            }else {
                return midlleIndex;
            }
        }
        return -1;
    }
}
