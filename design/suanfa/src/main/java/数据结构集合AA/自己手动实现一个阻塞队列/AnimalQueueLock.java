package 数据结构集合AA.自己手动实现一个阻塞队列;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengxin
 * @date 2021/7/13
 */
@Data
public class AnimalQueueLock {

    private final Queue<Animal> queue = new LinkedList<>();

    ReentrantLock reentrantLock = new ReentrantLock(true);
    private Condition condition = reentrantLock.newCondition();

    public void put(Animal animal) {
        reentrantLock.lock();
        try {
            queue.offer(animal);
            condition.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public Animal get() {
        reentrantLock.lock();
        try {
            while (queue.peek() == null) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return queue.poll();
    }


}
