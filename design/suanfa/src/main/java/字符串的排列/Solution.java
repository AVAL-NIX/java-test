package 字符串的排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author zhengxin
 * @date 2021/4/7
 */
public class Solution {

    /**
     * 递归法，问题转换为先固定第一个字符，求剩余字符的排列；求剩余字符排列时跟原问题一样。
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || "".equals(str)) {
            return result;
        }

        change(str.toCharArray(), result, 0);

        // 此时得到的result中排列并不是字典顺序，可以单独再排下序
        Collections.sort(result);
        return result;
    }

    /**
     * 开始递归
     *
     * @param str
     * @param result
     * @param i
     */
    private void change(char[] str, ArrayList<String> result, int begin) {
        if (begin == str.length - 1) {
            //递归结束,找到一个解
            result.add(String.valueOf(str));
        } else {
            //无限递归
            Set<Character> charSet = new HashSet<Character>();
            for (int j = begin; j < str.length; ++j) {
                // 判断有没有重复的
                if (j == begin || !charSet.contains(str[j])) {
                    charSet.add(str[j]);
                    //交换值
                    swap(str, begin, j);
                    //继续递归后面的字符
                    change(str, result, begin + 1);
                    //换回来
                    swap(str, j, begin);
                }
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        String a = "abfsaf";
        System.out.println(new Solution().Permutation(a).toString());
    }
}
