package 动态规划AA.最大子序和;

class Solution {
    public int maxSubArray(int[] nums) {
        int res = 0 ;
        if(nums.length == 0){
            return res;
        }
        //base case
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] , nums[i] + dp[i-1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
