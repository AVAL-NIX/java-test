package 动态规划AA.最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0 ;
        int res = 0;
        while(right < s.length()){
            char rt = s.charAt(right);
            right++;
            map.put(rt, map.getOrDefault(rt,0) + 1);

            while(map.get(rt) > 1){
                char lt = s.charAt(left);
                left++;
                map.put(lt, map.getOrDefault(lt,0) - 1);
            }

            res = Math.max(res, right-left);
        }
        return res;
    }
}