package 字符串集合AA.字符串解码;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> values = new Stack();
        Stack<Integer> op = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是数字 ， 操作数字
            if (Character.isDigit(c)) {
                digit = digit * 10 + Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                //如果是[ 把括号里面的数组放进去
                values.add(sb.toString());
                op.add(digit);
                sb = new StringBuilder();
                digit = 0;
            }else if (Character.isAlphabetic(c)){
                sb.append(c);
            }else{
                StringBuilder temp = new StringBuilder(values.pop());
                int tempValue = op.pop();
                for (int j = 0; j < tempValue; j++) {
                    temp.append(sb);
                }
                //赋值给外面的大字符串
                sb = new StringBuilder(temp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }
}