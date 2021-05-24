package 动态规划AA.子数组的最大累加和问题;


public class Solution {
    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray2(int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        //定义最大值
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public int maxsumofSubarray(int[] arr) {
// write code here
        if (arr.length == 0)
            return 0;
        int sum = arr[0];
        int max = sum;
        for (int i = 1; i < arr.length; i++) {
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
