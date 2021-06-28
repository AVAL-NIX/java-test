package 数组集合AA.顺时针旋转矩阵;

import java.util.*;

public class Solution {
    public int[][] rotateMatrix(int[][] mat, int n) {
        //左右交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
        //对角交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - j][n - 1 - i];
                mat[n - 1 - j][n - 1 - i] = temp;
            }
        }
        return mat;

    }
}