package 动态规划AA.零钱兑换;


import java.util.Arrays;
import java.util.Collections;

/**
 * DFS
 */
class Solution1 {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, 0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int res = Integer.MAX_VALUE;

    public void dfs(int[] coins, int index, long count, int amount) {
//        if (amount == 0) {
//            res = Math.min(res, (int) num);
//            return;
//        }
//        for (int j = i; j >= 0; j--) {
//            // # 剩下的最大值都不够凑出来了
//            System.out.println(" j:" + j + " ,   res :  " + res + " num : " + num + " coins[j]:" + ((res - num) * coins[j]) + " amount : " + amount);
//            if (((res - num) * coins[j]) < amount) {
//                System.out.println(" res :  " + res + " num : " + num + " coins[j]:" + coins[j] + " amount : " + amount);
//                break;
//            }
//            if (coins[j] > amount) {
//                continue;
//            }
//            dfs(coins, j, num + 1, amount - coins[j]);
//        }


        if (index < 0 || count + amount / coins[index] >= res)
            return;
        if (amount % coins[index] == 0) {
            res = Math.min(res, (int) count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            dfs(coins, index - 1, count + i, amount - i * coins[index]);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}
                , 9864));
    }
}
