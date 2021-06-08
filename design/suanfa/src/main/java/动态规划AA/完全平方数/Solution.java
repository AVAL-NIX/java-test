package 动态规划AA.完全平方数;

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        int num = 1;
        while (num * num < n) {
            int k = num * num;
            for (int i = 1; i < n; i++) {
                if (i >= k) {
                    dp[i] = Math.min(dp[i], dp[i - k] + 1);
                }
            }
            num++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}