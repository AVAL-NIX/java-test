package 数组集合AA.移动零;

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                if (i > nums.length - count - 1) {
                    break;
                }
                count++;
                //交换到最后
                for (int j = i; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            } else {
                i++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0, 0, 1});
    }
}