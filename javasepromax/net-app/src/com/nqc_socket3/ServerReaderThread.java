package com.nqc_socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    private Socket socket;

    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
            System.out.println(socket.getRemoteSocketAddress() + "下线了~~~");
        }
    }
}
