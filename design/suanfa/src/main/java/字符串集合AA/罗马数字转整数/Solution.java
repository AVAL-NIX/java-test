package 字符串集合AA.罗马数字转整数;

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int len = s.length();
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int num = map.get(c);
            if (pre < num) {
                result += num - pre *2 ;
                pre = Integer.MAX_VALUE;
            } else {
                pre = num;
                result += num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}