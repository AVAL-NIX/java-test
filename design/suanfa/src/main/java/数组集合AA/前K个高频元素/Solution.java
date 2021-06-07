package 数组集合AA.前K个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] m, Integer[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            //先进入K个数 进队列
            if (queue.size() < k) {
                queue.add(new Integer[]{item.getKey(), item.getValue()});
                continue;
            }
            //如果满了。 则判断 value 谁大留谁
            if (queue.peek()[1] < item.getValue()) {
                queue.poll();
                queue.add(new Integer[]{item.getKey(), item.getValue()});
            }
        }

        return queue.stream().mapToInt((item) -> {
            return item[0];
        }).toArray();
    }

    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}