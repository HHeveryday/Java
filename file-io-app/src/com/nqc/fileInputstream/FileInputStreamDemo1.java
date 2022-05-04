package com.nqc.fileInputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 使用字节流读取数据
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //1、建立连接
        InputStream in = new FileInputStream("D:\\code\\java\\javasepromax\\file-io-app\\src\\test.txt");
        //2、定义一个数组，用于接收
        byte[] buffer = new byte[3];
        int len = in.read(buffer);
        System.out.println("读取的字节个数" + len);
        String s = new String(buffer,0,len);
        System.out.println(s);

        int len1 = in.read(buffer);
        System.out.println("读取的字节个数" + len1);
        String s1 = new String(buffer,0,len1);
        System.out.println(s1);

        int len2 = in.read(buffer);
        System.out.println("读取的字节个数" + len2);
        String s2 = new String(buffer);
        System.out.println(s2);
    }
}
