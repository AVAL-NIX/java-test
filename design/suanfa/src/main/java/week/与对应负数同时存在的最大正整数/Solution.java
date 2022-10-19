package week.与对应负数同时存在的最大正整数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {

        Set<Integer> hashMap = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                hashMap.add(nums[i]);
            }
        }

        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int zhengshu = Math.abs(nums[i]);
                if (hashMap.contains(zhengshu)) {
                    max = Math.max(max, zhengshu);
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxK(new int[]{-1,2,-3,3}));
        System.out.println(new Solution().findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println(new Solution().findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }
}