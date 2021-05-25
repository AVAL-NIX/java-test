package 动态规划AA.最长回文子序列;

/**
 * TODO .  不会反着遍历
 * https://mp.weixin.qq.com/s/zNai1pzXHeB2tQE6AdOXTA
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][i] = 1;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] =  Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        System.out.println(new 动态规划AA.最长回文子序列.Solution().longestPalindromeSubseq("abbbc"));
    }
}