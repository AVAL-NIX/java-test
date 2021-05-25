package 动态规划AA.最长回文子序列;

/**
 * 给定一个字符串，找到其中最长的回文子序列，并返回该序列的长度。字符串长度<=5000
 * <p>
 * "abccsb"
 * 4
 *
 * @author zhengxin
 * @date 2021/4/12
 */
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string 一个字符串由小写字母构成，长度小于5000
     * @return int
     */
    public int longestPalindromeSubSeq(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        return func(s.toCharArray(), 0, s.length() - 1);
    }

    /**
     * 假设fun(char[] S , int i , int j) 返回的是串S[i...j]的最长回文子序列。
     * 则如果S[i]==S[j] , 则：fun(S, i , j) = 2+fun(S , i+1 , j-1)
     * 如果不等，则，fun(S , i , j) = max{ fun(S, i+1 , j) ,  fun(S , i , j-1)}
     *
     *
     * @param s
     * @param b
     * @param e
     * @return
     */
    private int func(char[] s, int b, int e) {
        //递归出口
        if (b == e) {
            return 1;
        }
        //递归出口
        if (b == e - 1) {
            return s[b] == s[e] ? 2 : 1;
        }

        if (s[b] == s[e]) {
            return 2 + func(s, b + 1, e - 1);
        } else {
            return Math.max(func(s, b, e - 1), func(s, b + 1, e));
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindromeSubSeq("bdccfb"));
    }
}
