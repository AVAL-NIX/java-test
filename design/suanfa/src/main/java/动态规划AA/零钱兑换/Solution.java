package 动态规划AA.零钱兑换;


/**
 * 动态规划
 */
class Solution {
    public int[] table ;
    public int coinChange(int[] coins, int amount) {
            table = new int[amount+1];
        return dp(coins, amount);
    }


    /**
     * 定义 ， 要凑出金额 amount ， 至少需要  dp(amount) 个硬币
     *
     * @param coins
     * @param amount 要凑的金额
     * @return 硬币数量
     */
    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if(table[amount]!=0){
            return table[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subproblem = dp(coins, amount - coins[i]);
            // 子问题无解，跳过
            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }
        table[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return table[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}
                , 9864));
    }
}
