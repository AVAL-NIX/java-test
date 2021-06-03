package 回溯算法AA.全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList track = new LinkedList();
        trackFn(nums, track);
        return res;
    }

    private void trackFn(int[] nums, LinkedList track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            // 排除不合法的选择
            if (track.contains(nums[j]))
                continue;

            track.add(nums[j]);

            trackFn(nums, track);

            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new 回溯算法AA.全排列.Solution().permute(new int[]{1, 2, 3}));
    }
}