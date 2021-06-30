package 动态规划AA.剪绳子2;

class Solution {
    public int cuttingRope(int n) {
        long[] dp = new long[n + 1];
        //base case
        dp[2] = 1;
        // i 从3开始
        for (int i = 3; i <= n; i++) {
            // 至少分成2段
            for (int j = 2; j <= i / 2 + 1; j++) {
                // 转移方程
                dp[i] = Math.max(Math.max(j * dp[i - j]  , j * (i - j)  ) , dp[i]);
            }
        }
        return (int) dp[n] %1000000007;
    }
}