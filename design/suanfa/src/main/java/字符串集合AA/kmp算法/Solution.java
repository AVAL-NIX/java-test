package 字符串集合AA.kmp算法;

import java.math.BigDecimal;
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * <p>
     * 计算模板串S在文本串T中出现了多少次
     *
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public int kmp(String S, String T) {
        // write code here

//        if(S.empty() || S.size() > T.size()) return 0; //边界处理
//        int res = 0, next[S.size() + 1]; //结果和next数组，next[x]的意义是长度为x的前子串最长相同前后缀长度
//        next[0] = -1; //第0位设置成-1表示需要右移被匹配字符指针
//        for(int pre = -1, cur = 0; cur < S.size();) { //用双指针在模板内部进行匹配
//            if(pre == -1 || S[pre] == S[cur]) { //当从头开始匹配或者双指针指向字符相同时
//                pre++; //左指针右移
//                cur++; //当前指针右移
//                next[cur] = pre; //更新该下标的next值为，（不含该下标之前字符串）最长相同前缀的后一位（即相同字符串长度）
//            }
//            else pre = next[pre]; //字符不相同时左指针更新为，（不含该字符之前的字符串）最长相同前缀的后一位（若该字符为S[0]则值为-1表示需要右移cur）
//        }
//        for(int pattern = 0, cur = 0; cur < T.size();) { //现在匹配模版串和文本串
//            if(pattern == -1 || S[pattern] == T[cur]) { //基本和上面一样
//                pattern++; //模板串指针右移
//                cur++; //文本串指针右移
//                if(pattern == S.size()) { //如果完全匹配
//                    res++; //结果加1
//                    pattern = next[pattern]; //模板指针指向（含当前字符）最长相同前缀后一个字符
//                }
//            }
//            else pattern = next[pattern]; //不相同时模板指针指向（不含该字符之前的字符串）最长相同前缀的后一位（若该字符为S[0]则值为-1表示需要右移文本串指针）
//        }
//        return res; //返回结果
        if (S == null || T == null || S.length() > T.length()) {
            return 0;
        }
        int res = 0;

        //统计S 串中的  相同数字的下标放入next 数组中
        int[] next = new int[S.length() + 1];
        //第0位设置成-1表示需要右移被匹配字符指针
        next[0] = -1;
        //用双指针在模板内部进行匹配
        for (int pre = -1, curr = 0; curr < S.length(); ) {
            //当从头开始匹配或者双指针指向字符相同时
            if (pre == -1 || S.charAt(pre) == S.charAt(curr)) {
                pre++; //左指针右移
                curr++; //当前指针右移
                //更新该下标的next值为，（不含该下标之前字符串）最长相同前缀的后一位（即相同字符串长度）
                next[curr] = pre;
            } else {
                //字符不相同时左指针更新为，（不含该字符之前的字符串）最长相同前缀的后一位（若该字符为S[0]则值为-1表示需要右移cur）
                pre = next[pre];
            }
        }

        for (int pattern = 0, curr = 0; curr < T.length(); ) {
            if (pattern == -1 || S.charAt(pattern) == T.charAt(curr)) {
                pattern++;    //模板串指针右移
                curr++; //文本串指针右移
                //如果完全匹配
                if (pattern == S.length()) {
                    res++; //结果加1
                    //模板指针指向（含当前字符）最长相同前缀后一个字符
                    pattern = next[pattern];
                }
            } else {
                //不相同时模板指针指向（不含该字符之前的字符串）最长相同前缀的后一位（若该字符为S[0]则值为-1表示需要右移文本串指针）
                pattern = next[pattern];
            }
        }


        return res;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().kmp("ababab", "abababab"));
    }
}