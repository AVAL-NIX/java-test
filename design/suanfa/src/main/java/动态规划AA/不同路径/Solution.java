package 动态规划AA.不同路径;

class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        track(m, n, 1, 1);
        return dp[1][1];
    }

    private int track(int m, int n, int i, int j) {
        if (m == i && n == j) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int v = 0;
        if (i < m) {
            v += track(m, n, i + 1, j);
        }
        if (j < n) {
            v += track(m, n, i, j + 1);
        }
        dp[i][j] = v;
        return v;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}