package 动态规划AA.n个骰子的点数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int count = 6;

    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][n * count + 1];
        List<Double> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= count * i; j++) {
                if (i == 1) {
                    dp[i][j] = 1.0 / (double) (count);

                } else {
                    int index = 1;
                    //累加和
                    while (j - index >= 0 && index <= count) {
                        dp[i][j] += dp[i - 1][j - index++] / count ;
                    }
                }
                if (i == n) {
                    res.add(dp[i][j]);
                }
            }
        }
        return res.stream().mapToDouble(Double::doubleValue).toArray();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dicesProbability(2)));
    }
}