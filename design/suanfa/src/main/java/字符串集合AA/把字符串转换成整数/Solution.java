package 字符串集合AA.把字符串转换成整数;

import java.util.*;

public class Solution {
    public int StrToInt(String str) {
        str = str.trim();
        // 0 - 1
        // 0 = +-号
        // 1 = 数字d 
        HashMap<Character, Integer> one = new HashMap<>();
        one.put('s', 1);
        one.put('d', 1);
        HashMap<Character, Integer> two = new HashMap<>();
        two.put('d', 1);
        HashMap<Character, Integer>[] stats = new HashMap[]{one, two};

        int result = 0;
        boolean falg = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char sign = c;
            if (c == '+' || c == '-') {
                sign = 's';
                falg = true;
            } else if (c >= '0' && c <= '9') {
                sign = 'd';
            } else {
                sign = '?';
            }
            if (!stats[result].containsKey(sign)) {
                break;
            }
            result = stats[result].get(sign);
        }

        if (result != 1) {
            return 0;
        }
        int res = 0;
        // true 为加法
        boolean addorsub = true;
        if (falg) {
            if (str.charAt(0) == '-') {
                addorsub = false;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (falg) {
                falg = false;
                continue;
            }
            if (addorsub) {
                res += (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);
            }else{
                res -= (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("-123"));
    }
}