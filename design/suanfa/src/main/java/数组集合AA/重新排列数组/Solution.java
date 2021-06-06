package 数组集合AA.重新排列数组;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for(int i=0; i< nums.length /2 ; i++){
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }
        return result;
    }
}