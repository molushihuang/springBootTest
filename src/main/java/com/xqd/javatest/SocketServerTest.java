package com.xqd.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("192.168.3.93", 9998));
            System.out.println("服务器启动");
            while (true){
                Socket socket = serverSocket.accept();
                new ReaderThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class ReaderThread extends Thread {

        BufferedReader mBufferedReader;

        public ReaderThread(Socket socket) {
            try {
                mBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            super.run();

            String content = null;
            while (true) {
                try {
                    if (((content = mBufferedReader.readLine()) != null)) {
                        System.out.println("接收到了客户端：" + content);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
