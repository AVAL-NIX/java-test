package 回溯算法AA.组合总和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        track(candidates, target, temp, 0);
        return res;
    }

    private void track(int[] candidates, int target, List<Integer> temp, int start) {
        if (target < 0) {
            return;
        }
        if (0 == target) {
            if (!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);

            track(candidates, target - candidates[i], temp, i);

            temp.remove(temp.size() - 1);
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}