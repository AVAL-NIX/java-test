package 数组集合AA.数组中的第K个最大元素;

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
       if(left <right){
           int mid = sortFn(nums, left, right);
           quickSort(nums, left , mid);
           quickSort(nums , mid + 1 , right);
       }
    }

    private int sortFn(int[] nums, int left, int right) {
        int fValue = nums[left];
        int leftT = left;
        int rightT = right;
        while (leftT < rightT){
            //右边
            while(leftT < rightT && nums[rightT] >= fValue){
                rightT--;
            }
            nums[leftT] =  nums[rightT];
            //左边
            while (leftT <rightT && nums[leftT] <= fValue){
                leftT++;
            }
            nums[rightT] = nums[leftT];
        }
        nums[leftT] = fValue;
        return leftT;
    }
}