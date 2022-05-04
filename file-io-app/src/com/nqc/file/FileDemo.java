package com.nqc.file;

import java.io.File;

/**
 * 路径写法
   第一种方式，使用\\作为分隔符
    File f = new File("D:\\test.png");
    第二种方式，使用/作为分隔符
    File f = new File("D:/test.png");
    第三种方式，使用File.separator作为分隔符，好处是可以跨平台使用
    File f = new File("D:"+File.separator+"test.png");
 */
public class FileDemo {
    public static void main(String[] args) {
        //1、创建File对象
        File f1 = new File("D:\\code\\java\\javasepromax\\file-io-app\\src\\data.txt");
        System.out.println(f1.length());


        //2、File创建对象，支持绝对路径 支持相对路径

        //相对路径：一般定位模块中的文件。相对到工程下

        File f2 = new File("src/data.txt");
        System.out.println(f2.length());
    }
}
