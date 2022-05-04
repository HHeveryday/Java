package com.nqc_socket4;

import com.nqc_socket3.ServerReaderThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现服务端可以同时处理多个客户端的消息，并且使用线程池进行优化
 */
public class ServerDemo1 {

    //定义一个静态线程池
    private static ExecutorService pool = new ThreadPoolExecutor(2, 3, 3,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        System.out.println("=============服务端启动成功==============");

        try {
            //1、注册端口
            ServerSocket serverSocket = new ServerSocket(6666);

            //2、定义一个死循环由主线程负责不断的接收客户端的Socket管道连接
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "上线了~~~");

                //3、每接收到一个客户端的Socket管道，包装为一个任务交给线程池
                pool.execute(new ServerReaderRunnable(socket));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
