package 滑动窗口集合AA.滑动窗口最大值;

import 滑动窗口集合AA.滑动窗口最大值.单调队列的实现.SingleQueue;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        SingleQueue window = new SingleQueue();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
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
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
