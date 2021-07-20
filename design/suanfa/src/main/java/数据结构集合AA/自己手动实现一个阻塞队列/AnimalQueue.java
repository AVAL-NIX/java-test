package 数据结构集合AA.自己手动实现一个阻塞队列;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengxin
 * @date 2021/7/13
 */
@Data
public class AnimalQueue {

    private final Queue<Animal> queue = new LinkedList<>();

    public synchronized void put(Animal animal) {
        queue.offer(animal);
        notifyAll();
    }

    public synchronized Animal get() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }


}
