package 动态规划AA.螺旋矩阵;

import java.util.*;

/**
 * 题目描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 */
public class Solution4 {

    public static void main(String[] args) {
        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] v = {{6, 9, 7}};
        int[][] c = {{3}, {2},{21},{1}};
        int[][] e = {{2,5},{8,4},{0,-1}};
        ArrayList<Integer> list = spiralOrder(e);
        System.out.println(list);
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return result;
        }
        int top = 0, left = 0, right = matrix[0].length, bottom = matrix.length;
        while ( left < right && top < bottom) {
            // 从左往右
            if (top <= bottom) {
                for (int i = left; i < right; i++) {
                    result.add(matrix[top][i]);
                }
            }
            left++;
            // 从上往下
            if (left <= right && top < bottom-1) {
                for (int i = top + 1; i < bottom; i++) {
                    result.add(matrix[i][right - 1]);
                }
            }
            top++;
            if (left <= right && top < bottom) {
                // 从右往左
                for (int i = right - 2; i >= left - 1; i--) {
                    result.add(matrix[bottom - 1][i]);
                }
            }
            right--;
            //  从下往上
            if (left <= right) {
                for (int i = bottom - 2; i >= top; i--) {
                    result.add(matrix[i][left - 1]);
                }
            }
            bottom--;
        }
        return result;
    }
}
