package 动态规划AA.打家劫舍2;

import org.springframework.ui.Model;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(range(nums, 0, n - 2), range(nums, 1, n-1));
    }


    public int dp(int[] nums, int i, int end) {
        //base case
        if (i >= end) {
            return 0;
        }
        int amount = Math.max(dp(nums, i + 1, end),
                nums[i] + dp(nums, i + 2, end));
        return amount;
    }


    public int range(int[] nums , int i , int end){
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int j = end; j >= i; j -- ) {
            dp[j] = Math.max(dp[j+1], nums[j] +  dp[j+2]);
        }
        return dp[i];
    }

}