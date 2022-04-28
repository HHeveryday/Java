package com.nqc.file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File f = new File("file-io-app/src/data.txt");
        System.out.println(f.length());
    }
}
