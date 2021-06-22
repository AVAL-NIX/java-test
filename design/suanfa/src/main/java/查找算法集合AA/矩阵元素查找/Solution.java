package 查找算法集合AA.矩阵元素查找;

import java.util.*;

public class Solution {

    public int[] findElement(int[][] mat, int n, int m, int x) {
        for (int i = 0, j = m - 1; i < n && j >= 0; ) {
            int value = mat[i][j];
            if (value == x) {
                return new int[]{i, j};
            } else if (value > x) {
                j--;
            } else if (value < x) {
                i++;
            }
        }
        return new int[]{};
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix.length - 1;
        while (i < matrix[0].length && j >= 0) {
            int v = matrix[j][i];
            if (v == target) {
                return true;
            }
            if (v > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(new Solution().findElement(new int[][]{{1, 2, 3}, {4, 5, 6}}, 2, 3, 6));
        System.out.println(new Solution().findNumberIn2DArray(new int[][]
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                },17
                ));
    }
}