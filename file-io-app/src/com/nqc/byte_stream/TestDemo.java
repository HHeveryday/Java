package com.nqc.byte_stream;

import java.io.*;

/**
 * 使用字节流对文件进行复制，支持一切类型
 */
public class TestDemo {
    public static void main(String[] args) {
        try {
            //1、定义输入流
            InputStream in = new FileInputStream("C:\\新建文件夹\\QLDownload\\急先锋\\急先锋 4K(超高清SDR).qlv");

            //2、定义输出流
            OutputStream out = new FileOutputStream("C:/test/new.qlv");

            //3、定义缓冲数组

            byte[] buffer = new byte[1024];

            int len;

            while ((len = in.read(buffer)) != -1){
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            System.out.println("复制完成！！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
