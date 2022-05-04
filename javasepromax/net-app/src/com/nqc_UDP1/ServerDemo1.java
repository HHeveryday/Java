package com.nqc_UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo1 {
    public static void main(String[] args) throws Exception {

        System.out.println("=============服务端启动===================");
        //1、创建服务端对象
        DatagramSocket socket = new DatagramSocket(8888);

        //2、创建一个数据包对象接收数据
        byte[] buffer = new byte[1024 * 64];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        //3、等待接收数据
        socket.receive(packet);

        //获取发送端的ip和端口
        String  ip = packet.getSocketAddress().toString();
        System.out.println("对方地址为：" + ip);

        int  port = packet.getPort();
        System.out.println("对方端口为：" + port);

        //4、取出数据即可
        int len = packet.getLength();
        String rs = new String(buffer, 0, len);
        System.out.println("接收的数据为：" + rs);
        socket.close();

    }
}
