package com.nqc_socket5;

import java.io.*;
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
                //把这个消息进行端口转发给全部的客户端socket管道
                sendMsgToAll(msg);
            }
        } catch (Exception e) {
            System.out.println(socket.getRemoteSocketAddress() + "下线了~~~");
            ServerDemo1.allonlinesocket.remove(socket);
        }
    }

    private void sendMsgToAll(String msg) throws Exception {
        for (Socket socket1 : ServerDemo1.allonlinesocket) {
            PrintStream ps = new PrintStream(socket1.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}
