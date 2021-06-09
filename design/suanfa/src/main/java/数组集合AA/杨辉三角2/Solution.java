package 数组集合AA.杨辉三角2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        List<Integer> result = Arrays.stream(dp[rowIndex]).boxed().collect(Collectors.toList());
        result.remove(0);
        return result;
    }

    public static void main(String[] args) {
        new Solution().getRow(4);
    }
}