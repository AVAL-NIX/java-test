package 动态规划AA.买卖股票的最佳时机含手续费;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return Math.max(dp_i_0, dp_i_1);
    }


    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            // 这里只要第2天比第1天高就可以卖出。。 妙啊。
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1] - fee;
            }
        }
        return ans;
    }
}