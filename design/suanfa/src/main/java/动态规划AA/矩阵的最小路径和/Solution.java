package 动态规划AA.矩阵的最小路径和;

import java.util.*;


public class Solution {
    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            int[] temp = matrix[i];
            for (int j = i; j < temp.length; j++) {
                dp[i][j] = matrix[i][j] +  Math.min(dp[i - 1][j] + matrix[i + 1][j], dp[i - 1][j] + temp[j + 1]);
            }
        }
        return dp[matrix.length][matrix.length];
    }
}