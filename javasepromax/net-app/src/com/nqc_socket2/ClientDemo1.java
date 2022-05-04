package com.nqc_socket2;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket编程实现多发多收
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        System.out.println("=========================客户端启动==================");
        try {
            //1、创建Socket通信管道请求与服务端的连接
            Socket socket = new Socket("127.0.0.1", 7777);

            //2、从Socket管道中得到一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();

            //3、将低级的字节输出流包装为高级打印流
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);

            while (true) {
                //4、发送消息
                System.out.println("请说：");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }

            //关闭资源
            // socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
