package 动态规划AA.不相邻最大子序列和;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算
     * @param n int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public long subsequence (int n, int[] array) {
         int res = 0;
        int[] dp = new int[n + 2];
       for(int i= n-1; i>=0 ; i--){
           dp[i] = Math.max(dp[i+1], array[i] + dp[i+2]);
       }
        return dp[0];
    }
}