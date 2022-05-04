package com.nqc.udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo1 {
    public static void main(String[] args) throws Exception {

        System.out.println("=============服务端启动===================");
        //1、创建服务端对象
        DatagramSocket socket = new DatagramSocket(8888);

        //2、创建一个数据包对象接收数据
        byte[] buffer = new byte[1024 * 64];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            //3、等待接收数据
            socket.receive(packet);
            //4、取出数据即可
            int len = packet.getLength();
            String rs = new String(buffer, 0, len);
            System.out.println("接收到来自IP:" + packet.getAddress() + "端口为：" + packet.getPort() + "的消息：" + rs);
        }

    }
}
