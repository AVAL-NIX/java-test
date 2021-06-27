package 字符串集合AA.表示数值的字符串;

import java.util.*;


public class Solution {
    public boolean isNumeric(String str) {
        //1) 若干空格,去掉
        str = str.trim();
        //标记是否出现数字
        boolean showNum = false;
        //标记是否出现点
        boolean showDot = false;
        //标记是否出现E
        boolean showE = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= '0' && c <= '9') {
                //5) 标记出现数字
                showNum = true;
            } else if (c == 'e' || c == 'E') {
                //2) 只能出现一个 'e' 或 'E' ，后面跟着一个 整数，且e前面必须有数字
                if (showE || !showNum) {
                    return false;
                }
                //标记E出现
                showE = true;
                //E不能结尾，如12e这样的，在把showNum标记为false
                showNum = false;
            } else if (c == '.') {
                //3) . 之前不能出现e，且必须出现数字，且点只能出现一次
                if (showDot || showE) {
                    return false;
                }
                //标记.出现了
                showDot = true;
                //. 点可以作为结尾， 这里showNum不用变成false   3. = true
            } else if (c == '-' || c == '+') {
                //4) +- 出现在0位置或者e/E的后第一个位置
                if (i != 0 && str.charAt(i - 1) != 'E' && str.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }

        }
        // 5) 至少出现一次数字
        return showNum;
    }
}