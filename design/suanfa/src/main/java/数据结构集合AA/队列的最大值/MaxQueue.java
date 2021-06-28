package 数据结构集合AA.队列的最大值;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaxQueue {

    Deque<Integer> v = new ArrayDeque<>();
    Deque<Integer> h = new ArrayDeque<>();

    public MaxQueue() {

    }

    public int max_value() {
        return v.isEmpty()? -1 : h.peek();

    }

    public void push_back(int value) {
        v.offer(value);
        //单调队列需要保留当前最大的值就行了，踢掉小于当前V的值
        while(!h.isEmpty() && value > h.peekLast()){
            h.pollLast();
        }
        h.offer(value);
    }

    public int pop_front() {
        if(v.isEmpty()){
            return -1;
        }
        if(v.peek().intValue() ==  h.peek().intValue()){
            h.poll();
        }
        return v.poll();
    }


    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        maxQueue.push_back(4);
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
    }
}




/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */