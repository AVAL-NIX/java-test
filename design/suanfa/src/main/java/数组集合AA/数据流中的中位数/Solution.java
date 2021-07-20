package 数组集合AA.数据流中的中位数;

import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {

    PriorityQueue<Integer> max = new PriorityQueue<>();

    PriorityQueue<Integer> min = new PriorityQueue<>((x, y) -> x - y);

    public void Insert(Integer num) {
        if (max.size() == min.size()) {
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
    }

    public Double GetMedian() {
        return (Double) (max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek());
    }


}