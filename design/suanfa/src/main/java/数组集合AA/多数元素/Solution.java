package 数组集合AA.多数元素;

class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int result = 1 ,  value = nums[0];
        for (int i = 1; i < len; i++) {
            if(nums[i] == value){
                result++;
            }else{
                result--;
            }
            if(result == 0){
                value = nums[i];
            }
        }
        return result;
    }
}