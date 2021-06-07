package 数组集合AA.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**

 *
 * 【笔记】将所有正数作为数组下标，置对应数组值为负值。
 * 那么，仍为正数的位置即为（未出现过）消失的数字。
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}