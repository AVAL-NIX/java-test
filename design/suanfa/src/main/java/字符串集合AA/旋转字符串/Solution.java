package 字符串集合AA.旋转字符串;

import java.util.*;


public class Solution {
    /**
     * 旋转字符串
     *
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    public boolean solve(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        int lenA = A.length();
        for (int i = 1; i < lenA - 1; i++) {
            String left = A.substring(0, i);
            String right = A.substring(i, A.length());
            if ((right + left).equals(B)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve(
                "youzan","zanyou"
        ));
    }
}