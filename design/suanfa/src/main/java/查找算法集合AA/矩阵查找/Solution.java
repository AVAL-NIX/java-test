package 查找算法集合AA.矩阵查找;

import java.util.*;


public class Solution {
    /**
     * @param matrix int整型二维数组
     * @param target int整型
     * @return bool布尔型
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write code here
        if (matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length;
        while (i < matrix.length && j >= 0) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            } else if (value < target) {
                i++;
            } else if (value > target) {
                j--;
            }
        }
        return false;
    }
}