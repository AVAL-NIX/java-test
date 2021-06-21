package 动态规划AA.换钱的最少货币数;

import java.util.*;


public class Solution {
    /**
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        // write code here
        table = new int[aim+1];
        return dp(arr,aim);
    }

    int[] table ;
    public int dp(int[] arr, int amount){
        //base case 
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(table[amount]!=0){
            return table[amount];
        }
        
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int subproblem = dp(arr, amount - arr[i]);
            if(subproblem == -1){
                continue;
            }
            res = Math.min(subproblem + 1, res);
        }
        res = res ==  Integer.MAX_VALUE ? -1 : res;
        table[amount] = res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minMoney(new int[]{5,2,3},20 ));
    }
}