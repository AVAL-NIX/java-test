package 回溯算法AA.字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

/**
 *  这种比较复杂
 */
public class Solution2 {

    /**
     * 推荐这种
     */
    class Solution {
        public ArrayList<String> Permutation(String s) {
            char[] arr = s.toCharArray();
            boolean[] visited = new boolean[arr.length];
            dfs(arr, "", visited);
            return new ArrayList<>(list);
        }

        Set<String> list = new HashSet<>();

        public void dfs(char[] arr, String s, boolean[] visited) {
            if (s.length() == arr.length) {
                list.add(s);
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                // || (i > 0 && !visited[i - 1] && arr[i - 1] == arr[i])  可以不要， 优化减少递归次数
                if (visited[i] || (i > 0 && !visited[i - 1] && arr[i - 1] == arr[i])){
                    continue;
                }
                visited[i] = true;
                dfs(arr, s + String.valueOf(arr[i]), visited);
                visited[i] = false;
            }
        }


    }


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



}