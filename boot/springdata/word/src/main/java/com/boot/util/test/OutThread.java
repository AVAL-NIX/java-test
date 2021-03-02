package com.boot.util.test;

class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (res.flag) {
                    try {
                        // 当前线程变为等待，但是可以释放锁
                        res.notify();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                System.out.println(res.userName + "--" + res.userSex);
            }
        }
    }
}
