package com.nqc_socket1;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Socket编程实现一发一收
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

            //4、发送消息
            ps.println("我是TCP的客户端，我已经与你对接，并发出邀请");
            ps.flush();

            //关闭资源
            // socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
