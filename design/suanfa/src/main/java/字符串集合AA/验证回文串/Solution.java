package 字符串集合AA.验证回文串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                arr.add(s.charAt(i));
            }
        }

        int len = arr.size();
        for (int i = 0; i < len / 2 && i <= len - i; i++) {
            if (!String.valueOf(arr.get(i)).equalsIgnoreCase(String.valueOf(arr.get(len - i - 1)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
}