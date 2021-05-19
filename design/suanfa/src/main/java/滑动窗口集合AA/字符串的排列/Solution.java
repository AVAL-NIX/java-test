package 滑动窗口集合AA.字符串的排列;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.toCharArray().length; i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        //滑动
        int left = 0, right = 0,  len = Integer.MAX_VALUE, valid = 0;
        while (right < s2.length()) {
            char add = s2.charAt(right);
            right++;
            //TODO
            if (need.containsKey(add)) {
                window.put(add, window.getOrDefault(add, 0) + 1);
                if (window.get(add).equals(need.get(add))) {
                    valid++;
                }
            }

            while (valid >= need.size()) {
                //更新最小覆盖子串 ， 判断len的
                if(right - left  == s1.length()){
                    return true;
                }

                char del = s2.charAt(left);
                left++;
                //TODO
                if (need.containsKey(del)) {
                    if (window.get(del).equals(need.get(del))) {
                        valid--;
                    }
                    window.put(del, window.getOrDefault(del, 0) - 1);
                }
            }

        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("eidboaoo",
                "eidboaoo"));
    }

}
