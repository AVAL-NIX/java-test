package 动态规划AA.打家劫舍;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    int[] memo;

    private int dp(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dp(nums, i + 1), nums[i] + dp(nums, i + 2));
        return memo[i];
    }

    //解法2 ， 自底向下
    public int rob2(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}