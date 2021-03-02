package com.boot.util.test;

/**
 * @author zhengxin
 * @date 2021/3/2
 */
public class Main {

    public static void main(String[] args) {
        Res res = new Res();
        IntThrad intThrad = new IntThrad(res);
        OutThread outThread = new OutThread(res);
        intThrad.start();
        outThread.start();
    }
}
