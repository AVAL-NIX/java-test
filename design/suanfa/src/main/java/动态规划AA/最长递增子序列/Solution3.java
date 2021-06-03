package 动态规划AA.最长递增子序列;

import java.util.Arrays;

class Solution3 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for(int j= 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i],res);
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLIS(new int[]{1,2,3,4,8}));
    }
}
