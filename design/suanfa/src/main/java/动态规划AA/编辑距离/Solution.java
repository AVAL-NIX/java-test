package 动态规划AA.编辑距离;

import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        return dp(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    int[][] dp;

    public int dp(String s1, String s2, int i, int j) {
        //base case
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;


        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            //本来就相等，不需要任何操作
            //s1[0..i] 和 s2[0..j] 的最小编辑距离等于
            //s1[0..i-1] 和 s2[0..j-1] 的最小编辑距离
            //也就是说 dp(i, j) 等于 dp(i-1, j-1)
            dp[i][j] = dp(s1, s2, i - 1, j - 1);
        } else {
            // # 解释：
            //# 我直接在 s1[i] 插入一个和 s2[j] 一样的字符
            //# 那么 s2[j] 就被匹配了，前移 j，继续跟 i 对比
            //# 别忘了操作数加一
            dp[i][j] = min(
                    //插入
                    dp(s1, s2, i, j - 1),  // s1 通过 i  插入， 所以J往前走一位
                    //删除
                    dp(s1, s2, i - 1, j), // s1.直接往前走一位， 就是删除
                    //替换 我直接把 s1[i] 替换成 s2[j]，这样它俩就匹配了
                    //同时前移 i，j 继续对比
                    dp(s1, s2, i - 1, j - 1)
            ) + 1;
        }

        return dp[i][j];
    }

    public int min(int i1, int i2, int i3) {
        return Math.min(Math.min(i1, i2), i3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }

}