package 动态规划AA.通配符匹配;

import java.util.*;

public class Solution {
    public boolean isMatch(String s, String p) {
        return dp(s, p, s.length(), p.length());
    }

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean dp(String str, String pattern, int i, int j) {
        int m = str.length();
        int n = pattern.length();
        //base case
        if (i == 0 && j == 0) {
            return true;
        }
        if (i >= 1 && j == 0) {
            return false;
        }


        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;
        if (pattern.charAt(j - 1) != '*') {
            if (i > 0) {
                boolean one = str.charAt(i - 1) == pattern.charAt(j - 1);
                boolean two = pattern.charAt(j - 1) == '?';
                if (one || two) {
                    res = dp(str, pattern, i - 1, j - 1);
                }
            }
            if (i == 0 && j > 0) {
                res = false;
            }
        } else {
            if (i >= 1 && j >= 1) {
                res = dp(str, pattern, i - 1, j - 1);
            }
            if (i >= 1) {
                res = res || dp(str, pattern, i - 1, j);
            }
            if (j >= 1) {
                res = res || dp(str, pattern, i, j - 1);
            }
        }

        // 将当前结果记入备忘录
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("hhh", "**h"));
    }
}