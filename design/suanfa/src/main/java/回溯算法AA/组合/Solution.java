package 回溯算法AA.组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输出 K的组合
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void trackFn(int n, int k, int start, LinkedList track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int j = start; j <= n; j++) {
            track.add(j);

            trackFn(n, k, j + 1, track);

            track.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        LinkedList track = new LinkedList();
        trackFn(n, k, 1, track);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new 回溯算法AA.组合.Solution().combine(4, 2));
    }


}