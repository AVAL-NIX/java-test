package 动态规划AA.最大正方形;

import java.util.*;


public class Solution {
    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] matrix) {
        if (matrix.length == 1) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                    }
                }
            }
        }
        return maxLen >> 1;
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(b, c), a);
    }
}