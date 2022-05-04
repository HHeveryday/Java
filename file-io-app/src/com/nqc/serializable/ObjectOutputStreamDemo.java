package com.nqc.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        //创建学生对象
        Student s = new Student("小明", 12, "14265");

        try(
                //对象序列化，将对象字节流包装成字节输出流管道
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/code/java/javasepromax/file-io-app/src/test2.txt"));) {
            oos.writeObject(s);
            System.out.println("对象序列化完成！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
