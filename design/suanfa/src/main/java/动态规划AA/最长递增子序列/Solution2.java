package 动态规划AA.最长递增子序列;

import java.util.Arrays;

class Solution2 {
    public int[] longestCommonSubsequence(String text1, String text2) {
        meno = new String[text1.length()][text2.length()];
        String result = dp(text1, 0, text2, 0);
        int[] res = new int[result.length()];
        for (int i = 0; i < result.toCharArray().length; i++) {
            res[i] = result.charAt(i);
        }
        return res;
    }

    String[][] meno;

    public String dp(String s1, int i, String s2, int j) {
        //base case
        if (s1.length() == i || s2.length() == j) {
            return "";
        }
        //状态转义
        if (meno[i][j] != "") {
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
