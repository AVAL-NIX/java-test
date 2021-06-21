package 动态规划AA.正则表达式匹配;

import java.util.HashMap;

class Solution {
    public boolean isMatch(String s, String p) {
        return dp(s, p, 0, 0);
    }

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean dp(String s, String p, int i, int j) {
        int m = s.length(), n = p.length();
        // base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // 记录状态 (i, j)，消除重叠子问题
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 有 * 通配符，可以匹配 0 次或多次
                // 1.1 通配符匹配 0 次或多次
                res = dp(s, p, i, j + 2)
                        || dp(s, p, i + 1, j);
            } else {
                // 无 * 通配符，老老实实匹配 1 次
                // 1.2 常规匹配 1 次
                res = dp(s, p, i + 1, j + 1);
            }
        } else {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 有 * 通配符，只能匹配 0 次
                // 2.1 通配符匹配 0 次
                res = dp(s, p, i, j + 2);
            } else {
                // 无 * 通配符，匹配无法进行下去了
                res = false;
            }
        }

        // 将当前结果记入备忘录
        memo.put(key, res);

        return res;
    }
}