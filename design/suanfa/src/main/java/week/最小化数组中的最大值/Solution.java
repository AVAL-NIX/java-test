package week.最小化数组中的最大值;

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max = getMax(nums);
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] > 1 && nums[i] >= max && nums[i - 1] + 1 <= max) {
                nums[i]--;
                nums[i - 1]++;
                max = getMax(nums);
                i = 1;
            }
        }

        return getMax(nums);
    }

    public int getMax(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r = Math.max(r, nums[i]);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeArrayValue(new int[]{13, 13, 20, 0, 8, 9, 9}));
    }
}