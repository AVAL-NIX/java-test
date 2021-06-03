package 查找算法集合AA.矩阵元素查找;

import java.util.*;

public class Solution {
    public int[] findElement2(int[][] mat, int n, int m, int x) {
        // write code here
        int left = 0 , right = n -1;
        while (left <= right){
            int mid = left + (right - left)/ 2;
            int l = mat[mid][0], r = mat[mid][m-1];
            if(x > r){
                left = mid +1;
            }else if (x <l){
                right = mid -1;
            }else if(x >= l || x <= r){
                //继续2分
                int left1 = 0 , right1 = m-1;
                while (left1 <= right1){
                    int mid1 = left1 + (right1 - left1) /2;
                    int value =mat[mid][mid1];
                    if(value == x){
                        return new int[]{mid,mid1};
                    }else if(value > x){
                        right1 = mid - 1;
                    }else if(value < x){
                        left1 = mid +1;
                    }
                }
            }
        }
        return  new int[]{};
    }


    public int[] findElement(int[][] mat, int n, int m, int x) {
        int left = 0 , right = n -1;
        for (int i = 0, j = m-1; i < n && j >=0; ) {
            int value = mat[i][j];
            if(value == x){
                return new int[]{i,j};
            }else if(value > x){
                j--;
            }else if(value < x){
                i++;
            }
        }
        return  new int[]{};
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findElement(new int[][]{{1,2,3},{4,5,6}},2,3,6));
    }
}