package 滑动窗口集合AA.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char add = s.charAt(right);
            right++;

            //TODO
            if (need.containsKey(add)) {
                window.put(add, window.getOrDefault(add, 0) + 1);
                if (window.get(add).equals(need.get(add))) {
                    valid++;
                }
            }


            while (valid == need.size()) {
                //是最小覆盖字串
                if (right - left == p.length()) {
                    result.add(left);
                }
                char del = s.charAt(left);
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
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaddaebabacd",
                "abc"));
    }
}
