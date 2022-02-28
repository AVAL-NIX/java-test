package 动态规划AA.最小花费爬楼梯;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs(int[] cost) {
        // write code here
        //定义最小花费数组
        int[] dp = new int[cost.length];
        int minCost = 0;
        // 因为最多可以走2步，所以从2开始
        for (int i = 2; i < cost.length; i++) {
            minCost = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            dp[i] = minCost;
        }
        return minCost;
    }
}