package com.nqc.recursion;

import java.io.File;

/**
 * 文件搜索
 * 非规律递归
 */

public class Demo2 {
    public static void main(String[] args) {
        searchFile(new File("C:/"),"ldcurl.exe");
    }


    /**
     * 搜寻某个目录下的全部文件，并输出要寻找文件的决定路径
     * @param dir
     * @param s
     */
    private static void searchFile(File dir, String s) {
        //1、判断传入的文件名是否为文件夹&&是否为空指针null
        if (dir != null && dir.isDirectory()){
            //2、提取当前目录下的一级目录
            File[] files = dir.listFiles();
            //3、判断当前目录下有文件才可以遍历，有文件，并且有权限，没有权限的话提取的为null
            if (files != null && files.length > 0 ){
                //4、遍历所有文件
                for (File file : files) {
                    if (file.isFile()){
                        if (file.getName().equals(s)){
                            System.out.println("找到了，其绝对路径为：" + file.getAbsolutePath());
                        }
                    }else {
                        //为文件夹，继续递归搜索
                        searchFile(file,s);
                    }
                }
            }
        }else {
            System.out.println("您的查找路径不为文件夹，不支持！！！");
        }
    }
}
