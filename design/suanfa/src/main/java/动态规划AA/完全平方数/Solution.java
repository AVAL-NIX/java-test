package 动态规划AA.完全平方数;

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; //  最坏情况每次都是 i
            for (int j = 1; i - j * j >= 0; j++) {
                //  dp[i- j*j]  +dp[j * j ] 因为总是等于 dp[j *j ] = 1
                // i - j * j 是上一个 dp[i] 的最小完全平方数
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}