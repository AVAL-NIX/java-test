package 动态规划AA.矩阵最长递增路径;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递增路径的最大长度
     *
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve(int[][] matrix) {
        // write code here
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(dfs(matrix, i, j, -1), max);
            }
        }
        return max;

    }

    private int dfs(int[][] matrix, int i, int j, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (pre >= matrix[i][j]) {
            return 0;
        }
        int max = 0;
        max = Math.max(dfs(matrix, i + 1, j, matrix[i][j]), max);
        max = Math.max(dfs(matrix, i - 1, j, matrix[i][j]), max);
        max = Math.max(dfs(matrix, i, j + 1, matrix[i][j]), max);
        max = Math.max(dfs(matrix, i, j - 1, matrix[i][j]), max);
        return max + 1;
    }
}