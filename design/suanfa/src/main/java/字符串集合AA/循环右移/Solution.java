package 字符串集合AA.循环右移;

import java.util.*;


public class Solution {
    /**
     * 位移后二进制串的十进制值
     *
     * @param str string字符串 二进制字符串
     * @param k   int整型 循环位移次数
     * @return long长整型
     */
    public long rotateRight(String str, int k) {
        StringBuilder sb = new StringBuilder(str);
        int len = str.length();
        for (int i = 0; i < k; i++) {
            char end = sb.charAt(len - 1);
            sb.insert(0, end);
            sb.deleteCharAt(sb.length() - 1);
        }
        String res = sb.toString();
        long total = 0;
        for (int i = 0; i < res.length(); i++) {
            total = total + Long.parseLong(String.valueOf(res.charAt(i))) * + Double.valueOf(Math.pow(2, len - 1 - i)).longValue();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotateRight("11001000010010101011110111110000110100001110000011011001", 21));
        //38006604801896320
        //38006604801896326
        //38006604801896326
        //10000111000001101100111001000010010101011110111110000110
        //10000111000001101100111001000010010101011110111110000110
    }
}