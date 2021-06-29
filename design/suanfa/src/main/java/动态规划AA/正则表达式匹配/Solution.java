package 动态规划AA.正则表达式匹配;

import java.util.HashMap;

class Solution {
    public boolean isMatch(String str, String pattern) {
        return dp(str, pattern, str.length() , pattern.length() );
    }

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean dp(String str, String pattern, int i, int j) {
        int m = str.length();
        int n = pattern.length();
        // base case
        if (i <= 0 && j <= 0) {
            return true;
        }
        if (i >= 1 && j <= 0) {
            return false;
        }

        // 记录状态 (i, j)，消除重叠子问题
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;

        if (pattern.charAt(j - 1) != '*') {
            if (i > 0) {
                //情况1 没有 . 和 * 那就是直接匹配 A[i-1] = B[j-1] ，继续向前匹配 A[i-2] = B[j-2]
                boolean one = str.charAt(i - 1) == pattern.charAt(j - 1);
                //情况2 如果是 . 那就是直接相等了 A[i-1] = B[j-1]，继续向前匹配 A[i-2] = B[j-2]
                boolean two = pattern.charAt(j - 1) == '.';
                if (one || two) {
                    res = dp(str, pattern, i - 1, j - 1);
                }
            }
        } else {
            //碰到 * 了，情况3 ， 处于忽略或者不忽略
            //忽略，往前面匹配 A[n-1] 没有 c , 那 B 最后2个字符忽略 ，继续向前匹配 A[i-1] = B[j-3]
            if (j >= 2) {
                res = dp(str, pattern, i, j - 2);
            }
            //不忽略 A[n-1] 中有 c , A中的 c 可以有一个或者多个，继续向前匹配 A[i-2] = B[j-2]
            // 处理一下边界条件   >= 1 && j >= 2
            if (i >= 1 && j >= 2) {
                // a = a* 这种情况
                boolean one = str.charAt(i - 1) == pattern.charAt(j - 2);
                // a = .* 这种情况
                boolean two = pattern.charAt(j - 2) == '.';
                if (one || two) {
                    //忽略或者不忽略 只要一个符合条件就行了
                    res = res || dp(str, pattern, i - 1, j);
                }
            }
        }

        // 将当前结果记入备忘录
        memo.put(key, res);
        return res;
    }


    public boolean isMatch2(String str, String pattern) {
        // str = A , pattern = B
        int n = str.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        //base case
        //空串为true , dp[0][0] = true
        dp[0][0] = true;
        //空串 A 跟 空串正则必不匹配, dp[i][0] = false
        for (int i = 1; i < n; i++) {
            dp[i][0] = false;
        }
        //转移方程，根据前面分析的来写
        for (int i = 0; i <= n; i++) {
            //上面已经处理过 j == 0 的情况了，下标直接从1开始
            for (int j = 1; j <= m; j++) {
                //分成空正则和非空正则两种
                //非空正则分为两种情况 * 和 非*
                if (pattern.charAt(j - 1) != '*') {
                    // 只要情况1或者情况2成立一个就OK了，基于 A 不为空串
                    if (i > 0) {
                        //情况1 没有 . 和 * 那就是直接匹配 A[i-1] = B[j-1] ，继续向前匹配 A[i-2] = B[j-2]
                        boolean one = str.charAt(i - 1) == pattern.charAt(j - 1);
                        //情况2 如果是 . 那就是直接相等了 A[i-1] = B[j-1]，继续向前匹配 A[i-2] = B[j-2]
                        boolean two = pattern.charAt(j - 1) == '.';
                        if (one || two) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                } else {
                    //碰到 * 了，情况3 ， 处于忽略或者不忽略
                    //忽略，往前面匹配 A[n-1] 没有 c , 那 B 最后2个字符忽略 ，继续向前匹配 A[i-1] = B[j-3]
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2];
                    }
                    //不忽略 A[n-1] 中有 c , A中的 c 可以有一个或者多个，继续向前匹配 A[i-2] = B[j-2]
                    // 处理一下边界条件   >= 1 && j >= 2
                    if (i >= 1 && j >= 2) {
                        // a = a* 这种情况
                        boolean one = str.charAt(i - 1) == pattern.charAt(j - 2);
                        // a = .* 这种情况
                        boolean two = pattern.charAt(j - 2) == '.';
                        if (one || two) {
                            //忽略或者不忽略 只要一个符合条件就行了
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }
        }
        //  dp[A.length][B.length] 就是最后结果
        return dp[n][m];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a",""));
    }

}