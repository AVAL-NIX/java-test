package 动态规划AA.最长公共子序列2;

import java.util.*;


public class Solution {
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        meno = new String[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(meno[i],"");
        }
        String result = dp(s1, 0, s2, 0);
        return result;
    }

    String[][] meno;

    public String dp(String s1, int i, String s2, int j) {
        //base case
        if (s1.length() == i || s2.length() == j) {
            return "";
        }
        //状态转义
        if (!meno[i][j].equals("")) {
            return meno[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            meno[i][j] = s2.charAt(j) + dp(s1, i + 1, s2, j + 1);
        } else {
            String dp = dp(s1, i + 1, s2, j);
            String dp1 = dp(s1, i, s2, j + 1);
            String temp = dp.length() > dp1.length() ? dp : dp1;
            meno[i][j] = temp;
        }
        return meno[i][j];
    }
}