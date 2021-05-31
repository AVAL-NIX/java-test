package 动态规划AA.买卖股票的最佳时机;

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);

        }
        return dp_i_0;
    }

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maxValue = Math.max(maxValue, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return maxValue;
    }

    /**
     *
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i][1] = Math.max(dp[i][1], -prices[i]);
        }
        return dp[n - 1][0];
    }


}