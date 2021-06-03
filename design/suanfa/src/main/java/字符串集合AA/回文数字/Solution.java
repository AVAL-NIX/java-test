package 字符串集合AA.回文数字;

import java.util.*;


public class Solution {
    /**
     * 使用额外空间了， ，
     *
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int left = 0, right = 0;
        String str = x + "";
        right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 不使用额外空间， ，
     *
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        // 1. 找到高位
        int hi = 1;
        while (x / hi >= 10) {
            hi *= 10;
        }

        while (x != 0) {
            int left = x / hi;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            // 2. 去掉最高位, 低位
            x = (x % hi) / 10;
            hi = hi / 100;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int t = x;
        while (t != 0) {
            reverse = reverse * 10 + t % 10;
            t /= 10;
        }
        return reverse == x;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome3(10101));
    }
}