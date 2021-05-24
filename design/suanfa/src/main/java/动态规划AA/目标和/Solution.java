package 动态规划AA.目标和;

import java.util.HashMap;

/**
 * TODO  01 背包问题
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return result;
        }
        this.target = target;
        this.result = dp(nums, 0, 0);
        return result;
    }

    int result;
    int target;

    public void backtrack(int[] nums, int i, int rest) {
        //base care
        if (i == nums.length) {
            if (rest == target) {
                result++;
            }
            return;
        }
        //穷举
        backtrack(nums, i + 1, rest - nums[i]);
        //穷举
        backtrack(nums, i + 1, rest + nums[i]);
    }


    // 备忘录
    HashMap<String, Integer> memo = new HashMap<>();

    public int dp(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == target)
                return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + rest;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
