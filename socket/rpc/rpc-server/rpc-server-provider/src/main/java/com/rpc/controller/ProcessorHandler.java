package com.rpc.controller;

import java.awt.geom.QuadCurve2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;


        try {
            ObjectInputStream objectInputStream1 = new ObjectInputStream(socket.getInputStream());

            //输入流 ， 数据呗。 。。 。


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
