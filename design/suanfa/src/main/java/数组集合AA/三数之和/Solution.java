package 数组集合AA.三数之和;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = twoSum(nums, i + 1, 0 - nums[i]);
            int tempValue = nums[i];
            for (List<Integer> integers : temp) {
                integers.add(nums[i]);
                result.add(integers);
            }
            while (i < nums.length - 1 &&  tempValue == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        if (nums.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList();
        for (int i = start, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            int iValue = nums[i];
            int jValue = nums[j];
            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j])));
                while (i < j && iValue == nums[i]) {
                    i++;
                }
                while (i < j && jValue == nums[j]) {
                    j--;
                }
            } else if (sum < target) {
                while (i < j && iValue == nums[i]) {
                    i++;
                }
            } else if (sum > target) {
                while (i < j && jValue == nums[j]) {
                    j--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
