package com.nqc_socket2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo1 {
    public static void main(String[] args) {
        System.out.println("=============服务端启动成功==============");

        try {
            //1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);

            //2、必须调用accept方法，等待接收客户端的socket连接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();

            //3、从socket通信管道得到一个字节输入流
            InputStream is = socket.getInputStream();

            //4、将字节输入流包装为缓冲字符输入流进行接收信息，其中还需要使用转换流将字节流转换为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //5、接收消息
            String msg;
            while ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
