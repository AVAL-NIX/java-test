package 字符串集合AA.最长公共前缀;

import java.util.*;


public class Solution {
    /**
     * 牛课
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

    /**
     * leecode
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        String pre = "";
        int preIndex = 0;
        while (true) {
            if (preIndex == strs[0].length()) {
                return pre;
            }
            pre += strs[0].charAt(preIndex);
            for (int i = 0; i < strs.length; i++) {
                String temp = strs[i];
                if (!isEquals(temp, pre)) {
                    if (pre.length() == 0) {
                        return pre;
                    }
                    return pre.substring(0, pre.length() - 1);
                }
            }
            preIndex++;
        }
    }

    public boolean isEquals(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        if(bLen > aLen){
            return false;
        }
        int i = 0, j = 0;
        while (i < aLen && j < bLen) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }


    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }



    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix2(new String[]{"ab","a","a"}));
    }
}