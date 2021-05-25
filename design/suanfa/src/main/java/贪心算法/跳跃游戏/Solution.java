package 贪心算法.跳跃游戏;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max < i) {
                return false;
            }
        }
        return max >= n - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
}