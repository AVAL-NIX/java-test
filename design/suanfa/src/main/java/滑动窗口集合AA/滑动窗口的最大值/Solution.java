package 滑动窗口集合AA.滑动窗口的最大值;

import java.util.*;

/**
 * 描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 */
public class Solution {

    public class SingleQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            // 然后将 n 加入尾部
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }


    public ArrayList<Integer> maxInWindows(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        SingleQueue window = new SingleQueue();
        for (int i = 0; i < nums.length && k > 0; i++) {
            //少进一个人
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                //进入
                window.push(nums[i]);
                //找到最大的
                result.add(window.max());
                //出去
                window.pop(nums[i - k + 1]);
            }
        }
        return result;
    }
}