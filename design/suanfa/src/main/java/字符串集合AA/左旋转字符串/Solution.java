package 字符串集合AA.左旋转字符串;

import java.util.Arrays;

class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public String LeftRotateString(String str, int n) {
        str = res(str, 0, n);
        str = res(str, n, str.length());
        str = res(str, 0, str.length());

        return str;
    }

    public String res(String s, int b, int e) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < (e - b) / 2; i++) {
            char t = arr[i + b];
            arr[i + b] = arr[e - i - 1];
            arr[e - i - 1] = t;
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("abcXYZdef", 3));
    }
}