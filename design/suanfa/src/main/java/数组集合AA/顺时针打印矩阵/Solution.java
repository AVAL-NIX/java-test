package 数组集合AA.顺时针打印矩阵;

import java.util.ArrayList;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int resIndex = 0;
        while (left <= right || bottom >= top) {
            // 从左往右
            for (int i = left; i <= right  && resIndex < res.length; i++) {
                res[resIndex++] = matrix[top][i];
            }
            top++;
            //从上往下
            for (int i = top; i <= bottom && resIndex < res.length; i++) {
                res[resIndex++] = matrix[i][right];
            }
            right--;
            //从右往左
            for (int i = right; i >= left && resIndex < res.length ; i--) {
                res[resIndex++] = matrix[bottom][i];
            }
            bottom--;
            //从下往上
            for (int i = bottom; i >= top && resIndex < res.length ; i--) {
                res[resIndex++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
    }


    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length<1){
            return new ArrayList<>();
        }
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        int max = matrix.length * matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        while(left <= right || top <= bottom){
            //zuo - you
            for (int i = left; i <= right && res.size() < max; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            //从上往下
            for (int i = top; i <= bottom && res.size() < max; i++) {
                res.add( matrix[i][right]);
            }
            right--;
            //从右往左
            for (int i = right; i >= left && res.size() < max ; i--) {
                res.add( matrix[bottom][i]);
            }
            bottom--;
            //从下往上
            for (int i = bottom; i >= top && res.size() < max ; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }


}