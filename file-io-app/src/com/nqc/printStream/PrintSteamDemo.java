package com.nqc.printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintSteamDemo {
    public static void main(String[] args) throws Exception {

        PrintStream ps = new PrintStream(new FileOutputStream("D:\\code\\java\\javasepromax\\file-io-app\\src\\test3.txt", true));
//        PrintStream ps = new PrintStream("D:\\code\\java\\javasepromax\\file-io-app\\src\\test3.txt");

        ps.println(97);
        ps.println('a');
        ps.println("测试");
        ps.close();
    }
}
