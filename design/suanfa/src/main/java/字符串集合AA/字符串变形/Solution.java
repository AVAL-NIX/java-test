package 字符串集合AA.字符串变形;

import java.util.*;

public class Solution {
    public static String trans(String s, int n) {
        if(n <= 0){
            return "";
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            //是大写
            if (65 <= aChar && aChar <= 90) {
                aChar += 32;
                stack.add(aChar);
            } else  if (97 <= aChar && aChar <= 122) {
                aChar -= 32;
                stack.add(aChar);
            }else{
                int len = stack.size();
                for (int i1 = 0; i1 < len; i1++) {
                    sb.append(stack.pop());
                }
                sb.append(aChar);
            }

        }
        if(stack.size() > 0){
            int len = stack.size();
            for (int i1 = 0; i1 < len; i1++) {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(trans("This is a sample", 16));
    }

}
