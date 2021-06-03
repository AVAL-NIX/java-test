package 动态规划AA.背包01;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     *
     * @param V  int整型 背包的体积
     * @param n  int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack(int V, int n, int[][] vw) {
        // write code here
        int[][] dp = new int[V + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                int vi = vw[i-1][0];
                int wi = vw[i-1][1];
                if (vi > j) {
                    // 当前背包容量装不下，只能选择不装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或者不装入背包，择优 j - vi 前面判断了越界问题。
                    dp[i][j] = Math.max(dp[i - 1][j - vi] + wi, dp[i - 1][j]);
                }
            }

        }
        return dp[n][V];
    }
}