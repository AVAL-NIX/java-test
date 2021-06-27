package 字符串集合AA.字符流中第一个不重复的字符;

import java.util.*;

public class Solution {
    // 用map来存储，并且LinkedHashMap 是有序的
    Map<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public char FirstAppearingOnce() {
        for (char c : map.keySet()) {
            //LinkedHashMap是有顺的，找到的第一个为1的
            if (map.get(c) == 1)
                return c;
        }
        return '#';
    }

}