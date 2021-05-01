package com.rpc.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
