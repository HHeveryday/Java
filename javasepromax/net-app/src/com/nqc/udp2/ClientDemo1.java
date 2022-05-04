package com.nqc.udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=============================客户端启动==================");
        //1、创建发送端对象，发送端自带默认的端口号
        DatagramSocket socket = new DatagramSocket(6667);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入：");
            String msg = sc.nextLine();
            //2、创建一个数据包，封装数据
            if ("exti".equals(msg)){
                System.out.println("成功离线~~~");
                socket.close();
                break;
            }
            byte[] data = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888);

            //3、发送数据
            socket.send(packet);
        }

    }
}
