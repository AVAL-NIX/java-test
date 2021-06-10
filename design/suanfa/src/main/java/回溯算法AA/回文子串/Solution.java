package 回溯算法AA.回文子串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countSubstrings(String s) {
        char[] a = s.toCharArray();
        List<Character> temp = new ArrayList<>();
        track(a, temp, 0);
        return res;
    }

    int res = 0;

    private void track(char[] a, List<Character> temp, int start) {
        if (temp.size() > 0) {
            String b = temp.stream().reduce(new StringBuilder(), (sb, s) -> sb.append(s), StringBuilder::append).toString();
            if (isPantie(b)) {
                res++;
            }
        }

        for (int j = start; j < a.length; j++) {
            temp.add(a[j]);
            track(a, temp, j + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isPantie(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}