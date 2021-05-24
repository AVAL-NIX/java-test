package 动态规划AA.两个字符串的最小ASCII删除和;

class Solution {
    /**
     * 常规解法
     *
     * @param s1
     * @param s2
     * @return
     */
//    public int minimumDeleteSum(String s1, String s2) {
//        meno = new int[s1.length()][s2.length()];
//        return dp(s1, 0, s2, 0);
//    }
//
//    int[][] meno;
//
//    public int dp(String s1, int i, String s2, int j) {
//        int res = 0;
//        //base case
//        if (s1.length() == i) {
//            for (; j < s2.length(); j++) {
//                res += s2.charAt(j);
//            }
//            return res;
//        }
//        if (s2.length() == j) {
//            for (; i < s1.length(); i++) {
//                res += s1.charAt(i);
//            }
//            return res;
//        }
//        //状态转义
//        if (meno[i][j] != 0) {
//            return meno[i][j];
//        }
//        if (s1.charAt(i) == s2.charAt(j)) {
//            meno[i][j] = dp(s1, i + 1, s2, j + 1);
//        } else {
//            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
//            meno[i][j] = Math.min( s1.charAt(i) +  dp(s1, i + 1, s2, j),  s2.charAt(j) + dp(s1, i, s2, j + 1));
//        }
//        return meno[i][j];
//    }


    /**
     * 其实是求最大公共字串
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        meno = new int[s1.length() + 1][s2.length() + 1];
        int totalSum = 0;
        for (int i = 0; i < s1.length(); i++) {
            totalSum += s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            totalSum += s2.charAt(i);
        }
        if (s1.length() == 0 || s2.length() == 0) {
            return totalSum;
        }
        return totalSum - 2 * dp(s1, 0, s2, 0);
    }

    int[][] meno;

    public int dp(String s1, int i, String s2, int j) {
        //base case
        if (s1.length() == i) {
            return 0;
        }
        if (s2.length() == j) {
            return 0;
        }
        //状态转义
        if (meno[i][j] != 0) {
            return meno[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            //如果相等 。 。 。则加入
            meno[i][j] = dp(s1, i + 1, s2, j + 1) + s1.charAt(i);
        } else {
            // 如果不相等 。 。 。则比较
            meno[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return meno[i][j];
    }


    public static void main(String[] args) {
        //315
        System.out.println(new Solution().minimumDeleteSum("abcbvc", "abc"));
    }

}