package 数据结构集合AA.自己手动实现一个阻塞队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestLockInterruptibly {

    public static List<Integer> arr = new ArrayList<>(200000);
    static Executor executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        //   new TestLockInterruptibly().test3();
        test1(555);
        test2();
    }

    public static void test1(int k) throws Exception {
        long btime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> arr.add(new Random().nextInt()));
            thread.start();
            thread.join();
        }
        long endtime = System.currentTimeMillis();

        System.out.println("花费的时间：" + (endtime - btime));


        System.out.println("list size : " + arr.size());
    }

    public static void test2() throws Exception {
        long btime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> arr.add(new Random().nextInt()));
            executor.execute(thread);
            
        }
        long endtime = System.currentTimeMillis();


        System.out.println("22花费的时间：" + (endtime - btime));
        System.out.println("22list size : " + arr.size());
    }

    // @Test
    public void test3() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(1000000);
    }
}

