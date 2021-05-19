package 滑动窗口集合AA.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        int valid = 0;
        while (right < s.length()) {
            char add = s.charAt(right);
            right++;
            window.put(add, window.getOrDefault(add, 0) + 1);

            while (window.get(add) > 1) { //只能出现一次
                //收缩左侧
                char del = s.charAt(left);
                left++;
                window.put(del,window.getOrDefault(del,0) - 1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
