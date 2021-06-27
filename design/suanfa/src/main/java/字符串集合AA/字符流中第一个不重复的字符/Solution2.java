package 字符串集合AA.字符流中第一个不重复的字符;

import java.util.*;

public class Solution2 {

    Map<Character, Integer> map = new HashMap<>();
    LinkedList<Character> link = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        int count = map.get(ch);
        if (count == 1) {
            link.add(ch);
        } else if (count > 1) {
            link.remove((Object) ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (link.isEmpty()) {
            return '#';
        }
        return link.peek();
    }

    public static void main(String[] args) {
        String a = "google";
        Solution2 s = new Solution2();
        for (int i = 0; i < a.toCharArray().length; i++) {
            s.Insert(a.charAt(i));
        }
    }
}