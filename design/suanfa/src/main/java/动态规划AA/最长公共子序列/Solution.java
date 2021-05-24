package 动态规划AA.最长公共子序列;

import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        meno = new int[text1.length()][text2.length()];
        return dp(text1, 0, text2, 0);
    }

    int[][] meno;

    public int dp(String s1, int i, String s2, int j) {
        //base case
        if (s1.length() == i || s2.length() == j) {
            return 0;
        }
        //状态转义
        if (meno[i][j] != 0) {
            return meno[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            meno[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            meno[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return meno[i][j];
    }
}