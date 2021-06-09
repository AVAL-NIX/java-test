package 动态规划AA.最长连续序列;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        int result = 0;
        for (Integer i : s) {
            //如果这个数，没有前数， 则进入
            if (!s.contains(i - 1)) {
                int len = 1;
                int k = i + 1;
                while (s.contains(k)) {
                    len++;
                    k++;
                }
                result = Math.max(len, result);
            }
        }
        return result;
    }
}