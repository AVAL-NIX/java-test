package 回溯算法AA.字母异位词分组;

import java.util.*;
import java.util.Map.Entry;

class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> set = new HashMap<>();

        List<List<String>> res = new ArrayList<>();
        //去重
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            //去重复
            Arrays.sort(s);
            String key = Arrays.toString(s);
            if (set.containsKey(key)) {
                List<String> temp = set.get(key);
                temp.add(String.valueOf(strs[i]));
                set.put(key, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(String.valueOf(strs[i]));
                set.put(key, temp);
            }
        }
        for (Entry<String, List<String>> stringListEntry : set.entrySet()) {
            res.add(stringListEntry.getValue());
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}