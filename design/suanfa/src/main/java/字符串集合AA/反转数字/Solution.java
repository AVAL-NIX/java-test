package 字符串集合AA.反转数字;

import java.util.*;


public class Solution {
    /**
     * @param x int整型
     * @return int整型
     */
    public int reverse(int x) {
        int rever = 0;
        while (x != 0) {
            rever = rever * 10 + x % 10;
            x /=10;
        }
        return rever;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }
}