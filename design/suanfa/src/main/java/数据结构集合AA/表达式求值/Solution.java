package 数据结构集合AA.表达式求值;

import org.omg.CORBA.portable.ValueBase;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        Stack<Integer> values = new Stack<>();
        int d = 0;
        //记录操作符
        char sign = '+';
        for (int i = 0; i < arr.length; i++) {
            char a = arr[i];
            //空格跳过
            if (a == ' ') {
                continue;
            }
            // 数字进位
            if (Character.isDigit(a)) {
                d = d * 10 + a - '0';
            }
            // (( ) 可能出现括号嵌套的现象
            if (a == '(') {
                int j = i + 1;
                //统计(的个数
                int count = 1;
                while (count > 0) {
                    if (arr[j] == '(') {
                        count++;
                    }
                    if (arr[j] == ')') {
                        count--;
                    }
                    j++;
                }
                d = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            //计算结果 , 非数字 或者 到结尾了
            if (!Character.isDigit(a) || i == arr.length - 1) {
                switch (sign) {
                    case '+':
                        // 正数直接push
                        values.push(d);
                        break;
                    case '-':
                        // -号加上负数
                        values.push(-1 * d);
                        break;
                    case '*':
                        // 乘号相乘就OK了。
                        values.push(values.pop() * d);
                        break;
                    case '/':
                        // 除号相/就OK了。
                        if (d == 0) {
                            values.pop();
                            values.push(0);
                        } else {
                            values.push(values.pop() / d);
                        }
                        break;
                    default:
                        break;
                }
                d = 0;
                //记录上一个操作符
                sign = a;
            }
        }
        int res = 0;
        while (!values.isEmpty()) {
            res += values.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve("(11+2) * 2 "));
    }
}