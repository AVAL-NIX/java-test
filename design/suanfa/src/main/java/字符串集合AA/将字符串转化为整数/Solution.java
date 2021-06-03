package 字符串集合AA.将字符串转化为整数;

import java.util.*;


public class Solution {
    /**
     * @param str string字符串
     * @return int整型
     */
    public int atoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        str = str.trim();
        int index = str.indexOf("-");
        if (index == -1) {
            index = str.indexOf("+");
            if (index == -1) {
                index = 0;
            }
        }
        str = str.replace("-", "");
        str = str.replace("+", "");
        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) {
                index++;
            } else {
                break;
            }
        }
        str = str.substring(0, index);
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().atoi("-1209792x4157"));
    }
}