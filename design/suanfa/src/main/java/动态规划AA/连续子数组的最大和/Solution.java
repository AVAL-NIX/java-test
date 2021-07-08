package 动态规划AA.连续子数组的最大和;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int n = nums.length;
        if(n == 0){
            return max;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        max = nums[0];
        for(int i=1; i < n ; i++){
            dp[i] = Math.max(nums[i] , dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        dp();
    }

    public static void dp(){
        dp();
    }
}