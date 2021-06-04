package 数组集合AA.删除有序数组中的重复项;

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int slow = 0;
        int fast = 1;
        while ( slow < n && fast < n ) {
            boolean flag = false;
            while (fast < n && nums[slow] == nums[fast]) {
                fast++;
                if (fast == n) {
                    fast--;
                    flag = true;
                    break;
                }
            }
            if(slow == fast){
                return slow + 1;
            }
            nums[slow + 1] = nums[fast];
            slow++;
            if (flag) {
                break;
            }
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 2}));
    }
}