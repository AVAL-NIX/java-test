package 数据结构集合AA.自己手动实现一个阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengxin
 * @date 2021/7/13
 */
public class Main {

    //    public static AnimalQueue animalQueue = new AnimalQueue();
    public static AnimalQueueLock animalQueue = new AnimalQueueLock();
    static ReentrantLock lock = new ReentrantLock();
    static  Condition condition = lock.newCondition();

    public static class InsertTread extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println("开始插入一个数据");
            try {
                condition.await();
                System.out.println("开始插入一个数据OK");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

//            for (int i = 0; i < 10000000; i++) {
//                System.out.println("开始插入一个数据" + i);
////                animalQueue.put(new Animal(i + ""));
//                System.out.println("开始插入一个数据结束" + i);
//                try {
////                    Thread.sleep(10000);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public static class TakeTread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("开始获取一个数据" + i);
                animalQueue.get();
                System.out.println("开始获取一个数据结束" + i);
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            InsertTread a1 = new InsertTread();
            a1.start();
            System.out.println(" 线程 " + i);
        }
    }
}
