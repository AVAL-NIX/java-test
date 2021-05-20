package 数组集合AA.N数之和;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (n < 2 || len < n) {
            return result;
        }
        if (n == 2) {
            ////////// 2数之和
            int left = start, right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right];
                int leftValue = nums[left];
                int rightValue = nums[right];
                if (temp == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(leftValue);
                    res.add(rightValue);
                    result.add(res);
                    while (left < right && leftValue == nums[left]) {
                        left++;
                    }
                    while (left < right && rightValue == nums[right]) {
                        right--;
                    }
                } else if (temp > target) {
                    while (left < right && rightValue == nums[right]) {
                        right--;
                    }
                } else if (temp < target) {
                    while (left < right && leftValue == nums[left]) {
                        left++;
                    }
                }
            }
        } else {
            ///////  3 数之和
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> res = nSum(nums, n - 1, i + 1, target - nums[i]);
                if (res.size() > 0) {
                    for (List<Integer> re : res) {
                        re.add(nums[i]);
                        result.add(re);
                    }
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
