package 字符串集合AA.大数加法;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        boolean isUp = false;
        String s1 = reveers(s);
        String t1 = reveers(t);
        int i = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s1.length() || j < t1.length()) {
            int count = 0;
            if (isUp) {
                count++;
            }
            isUp = false;
            if (i >= s1.length() && j < t1.length()) {
                count += charToInt(t1.charAt(j));
                stringBuilder.append(count % 10);
                j++;
            } else if (i < s1.length() && j >= t1.length()) {
                count += charToInt(s1.charAt(i));
                stringBuilder.append(count % 10);
                i++;
            } else if (i < s1.length() && j < t1.length()) {
                count += Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(t1.charAt(j)));
                stringBuilder.append(count % 10);
                i++;
                j++;
            } else {
                System.out.println(i + ", " + j);
            }
            if (count >= 10) {
                isUp = true;
            }
        }
        if (isUp) {
            stringBuilder.append("1");
        }
        return reveers(stringBuilder.toString());
    }

    private int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    private String reveers(String t) {
        char[] arr = t.toCharArray();
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return String.valueOf(arr);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().solve("1001", "999"));
    }

}