package 字符串集合AA.最长公共前缀;

import java.util.*;


public class Solution {
    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            while (curr.indexOf(pre) < 0 && pre.length() > 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"a", "b"}));
    }
}