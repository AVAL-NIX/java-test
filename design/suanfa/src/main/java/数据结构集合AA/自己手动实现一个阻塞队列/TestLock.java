package 数据结构集合AA.自己手动实现一个阻塞队列;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock
{
    public void test() throws Exception
    {
        final Lock lock = new ReentrantLock();
        lock.lock();

        System.out.println("1");

        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("2");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        },"child thread -1");

        t1.start();
        Thread.sleep(1000);
        System.out.println("3");

        t1.interrupt();
        System.out.println("4");

        Thread.sleep(10000);
        System.out.println("5");
    }

    public static void main(String[] args) throws Exception
    {
        new TestLock().test();
    }
}