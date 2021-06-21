package 查找算法集合AA.矩阵元素查找;

import java.util.*;

public class Solution {

    public int[] findElement(int[][] mat, int n, int m, int x) {
        int left = 0, right = n - 1;
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


    public static void main(String[] args) {
        System.out.println(new Solution().findElement(new int[][]{{1, 2, 3}, {4, 5, 6}}, 2, 3, 6));
    }
}