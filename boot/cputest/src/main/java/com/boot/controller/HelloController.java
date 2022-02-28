package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

    /**
     * 模拟CPU占满
     */
    @GetMapping("/cpu/loop")
    public void testCPULoop() throws InterruptedException {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }


    /**
     * 模拟内存泄漏
     */
    @GetMapping(value = "/memory/leak")
    public String leak() {
        System.out.println("模拟内存泄漏");
        ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();
        localVariable.set(new Byte[4096 * 1024]);// 为线程添加变量
        return "ok";
    }


    ExecutorService service = new ThreadPoolExecutor(4, 10,
            0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    /**
     * 模拟死锁
     */
    @GetMapping("/cpu/test")
    public String testCPU() throws InterruptedException {
        System.out.println("请求cpu");

        Object lock1 = new Object();
        Object lock2 = new Object();
        service.submit(new DeadLockThread(lock1, lock2), "deadLookThread-" + new Random().nextInt());
        service.submit(new DeadLockThread(lock2, lock1), "deadLookThread-" + new Random().nextInt());
        return "ok";
    }




    @GetMapping("/test/get")
    public String get(Student student) throws InterruptedException {
        System.out.println(" aa " + student.toString());
        return "get";
    }

    @GetMapping("/test/get1")
    public String get1(String username) throws InterruptedException {
        System.out.println(" aaa : " + username);
        return "get1";
    }


    @PostMapping("/test/post")
    public String post1(Student student) throws InterruptedException {
        System.out.println(" aa " + student.toString());
        return "post";
    }

    @PostMapping("/test/post1")
    public String post1(String username) throws InterruptedException {
        System.out.println(" aa " + username);
        return "post1";
    }

    @PostMapping("/test/post2")
    public String post2(@RequestBody  Student student) throws InterruptedException {
        System.out.println(" aa " + student.toString());
        return "post2";
    }

    @PostMapping("/test/post3")
    public String post3(@RequestBody  String username) throws InterruptedException {
        System.out.println(" aa " + username);
        return "post3";
    }


    public class DeadLockThread implements Runnable {
        private Object lock1;
        private Object lock2;

        public DeadLockThread(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName()+"get lock2 and wait lock1");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+"get lock1 and lock2 ");
                }
            }
        }
    }


    @GetMapping(value = "/thread/swap")
    public String theadSwap(int num) {
        System.out.println("模拟线程切换");
        for (int i = 0; i < num; i++) {
            new Thread(new ThreadSwap1(new AtomicInteger(0)),"thread-swap"+i).start();
        }
        return "ok";
    }
    public class ThreadSwap1 implements Runnable {
        private AtomicInteger integer;

        public ThreadSwap1(AtomicInteger integer) {
            this.integer = integer;
        }

        @Override
        public void run() {
            while (true) {
                integer.addAndGet(1);
                Thread.yield(); //让出CPU资源
            }
        }
    }


}
