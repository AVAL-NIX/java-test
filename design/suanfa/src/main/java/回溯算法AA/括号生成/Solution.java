package 回溯算法AA.括号生成;

import java.util.*;


public class Solution {
    /**
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        trackFn(n, "", 0, 0);
        return res;
    }

    ArrayList<String> res = new ArrayList<>();

    private void trackFn(int n, String track, int left, int right) {
        if (n == left && n == right) {
            res.add(track);
            return;
        }
        if (left < n) {
            trackFn(n, track + "(", left + 1, right);
        }
        if (left > right) {
            trackFn(n, track + ")", left, right + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}