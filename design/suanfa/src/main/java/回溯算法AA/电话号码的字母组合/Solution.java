package 回溯算法AA.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> letterCombinations(String digits) {
        //base
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
        int len = digits.length();
        List<Character[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(map.get(digits.charAt(i)));
        }
        List<Character> temp = new ArrayList<>();

        //回朔
        track(list, temp, len, 0);
        return res;
    }

    List<String> res = new ArrayList<>();

    private void track(List<Character[]> list, List<Character> temp, int len, int start) {
        //base case
        if (temp.size() == len) {
            res.add(temp.stream().reduce(new StringBuilder(), (sb, s) -> sb.append(s), StringBuilder::append).toString());
            temp = new ArrayList<>();
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Character[] c = list.get(i);
            for (int j = 0; j < c.length; j++) {
                temp.add(c[j]);
                track(list, temp, len, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}