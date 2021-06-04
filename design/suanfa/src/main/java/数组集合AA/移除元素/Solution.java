package 数组集合AA.移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int n = nums.length;
        int result = n - 1;
        while (slow <= result) {
            if (nums[slow] == val) {
                while (result > 0 && nums[result] == val) {
                    result--;
                }
                if (result >= slow) {
                    int temp = nums[slow];
                    nums[slow] = nums[result];
                    nums[result] = temp;
                    result--;
                }
            }
            if (slow <= result) {
                slow++;
            }
        }
        return slow;
    }


    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{4, 5}, 5));
    }
}