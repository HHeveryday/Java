package com.nqc_socket5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现服务端可以同时处理多个客户端的消息
 */
public class ServerDemo1 {
    //定义一个静态的list集合存储当前全部在线的socket管道
    public static List<Socket> allonlinesocket = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("=============服务端启动成功==============");

        try {
            //1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);

            //2、定义一个死循环由主线程负责不断的接收客户端的Socket管道连接
            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "上线了~~~");
                allonlinesocket.add(socket);
                //3、每接收到一个客户端的Socket管道，交给一个独立的子线程负责读取消息
                new ServerReaderThread(socket).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
