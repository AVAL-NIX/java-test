package 字符串集合AA.第一个只出现一次的字符;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        LinkedList<Character> sort = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            hash.put(c, hash.getOrDefault(c, 0) + 1);
            int value = hash.get(c);
            if (value == 2) {
                sort.remove((Character) c);
            } else if (value == 1) {
                sort.addLast(c);
            }
        }
        return str.indexOf(sort.getFirst());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("abcfdsaf"));
    }
}