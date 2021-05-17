package 字符串集合AA.括号序列;

import java.util.*;


public class Solution {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char temp = s.charAt(i);
            if (temp == '{' || temp == '[' || temp == '(') {
                stack.push(temp);
            }
            if (!stack.isEmpty() && (temp == '}' || temp == ']' || temp == ')')) {
                if(temp == '}' && stack.peek()=='{'){
                    stack.pop();
                }
                if(temp == ')' && stack.peek()=='('){
                    stack.pop();
                }
                if(temp == ']' && stack.peek()=='['){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        boolean flag = true;
        while(flag){
            int len = s.length();
            s=s.replace("()","");
            s=s.replace("[]","");
            s=s.replace("{}","");
            if(len == s.length()){
                flag=false;
            }
        }
        return s.length() == 0;
    }
}
