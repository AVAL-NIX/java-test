package 数组集合AA.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 前后指针
 */
class Solution {
    /**
     * 有序的情况下
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            }
        }
        return new int[0];
    }

    /**
     * 无序的情况下
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (target - temp == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 无序的情况下
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> hash = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            if (hash.containsKey(target - temp)) {
                return new int[]{hash.get(target - temp), i};
            }
            hash.put(temp, i);
        }
        return new int[0];
    }


}
