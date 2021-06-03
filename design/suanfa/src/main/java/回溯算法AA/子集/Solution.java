package 回溯算法AA.子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    /**
     * 常规暴力解法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numsI = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return subsetsFn(numsI);
    }


    public List<List<Integer>> subsetsFn(List<Integer> nums) {
        //base case
        int n = nums.size();
        if (n == 0) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> result1 = new ArrayList<>();
            result.add(result1);
            return result;
        }
        int last = nums.get(n - 1);
        nums.remove(n - 1);
        // 先递归算出前面元素的所有子集
        List<List<Integer>> res = subsetsFn(nums);

        int size = res.size();
        for (int i = 0; i < size; i++) {
            //先复制上一个集合， 然后在添加last这个数
            res.add(new ArrayList<>(res.get(i)));

            //最后一个添加 last这个数
            List<Integer> temp = res.get(res.size() - 1);
            temp.add(last);
        }
        return res;
    }

    /**
     * 回溯算法
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> track = new ArrayList<>();
        trackFn(nums, 0, track);
        return res;
    }

    private void trackFn(int[] nums, int i, List<Integer> track) {
        res.add(track.stream().collect(Collectors.toList()));
        //
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);

            trackFn(nums, j + 1, track);

            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
        System.out.println(new Solution().subsets2(new int[]{1, 2, 3}));
    }

}