package com.nqc_UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=============================客户端启动==================");
        //1、创建发送端对象，发送端自带默认的端口号
        DatagramSocket socket = new DatagramSocket(6666);

        //2、创建一个数据包，封装数据

        /**
         *     public DatagramPacket(byte buf[], int length,
         *                           InetAddress address, int port) {
         *                           参数一：封装要发送的数据
         *                           参数二：要发送数据的大小
         *                           参数三：服务端的主机IP地址
         *                           参数四：服务端的端口
         */

        byte[] data = "测试数据~~~".getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888);

        //3、发送数据
        socket.send(packet);

        socket.close();
    }
}
