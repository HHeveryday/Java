package com.nqc.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo2 {
    public static void main(String[] args) {
        try (
                ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/code/java/javasepromax/file-io-app/src/test2.txt"));){
            Student s = (Student) is.readObject();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
