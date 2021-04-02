package 最长回文子串;

import java.util.*;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 *
 * @author zhengxin
 * @date 2021/4/2
 */
public class Solution {

    /**
     * 暴利解法
     * 18行动态规划+27行中心扩散法+36行马拉车算法
     *
     * @param A
     * @param n
     * @return
     */
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String now = A.substring(i, j);
                if (isPalindrome(now)) {
                    maxlen = now.length();
                }
            }
        }
        return maxlen;
    }

    /**
     * 判断是不是最长回文子串
     *
     * @param a
     * @return
     */
    private boolean isPalindrome(String a) {
        int len = a.length();
        for (int i = 0; i < len / 2; i++) {
            if (a.charAt(i) != a.charAt(len - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int cap = 32;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int result =  (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
        System.out.println(result);
    }
}
