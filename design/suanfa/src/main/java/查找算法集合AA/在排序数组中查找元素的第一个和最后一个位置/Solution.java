package 查找算法集合AA.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int len = nums.length;
        if(len == 0){
            return res;
        }
        int left = 0, right = len-1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                //处理边界问题
                int n1 = mid , n2 = mid;
                //往前找
                while(n1 - 1 >= 0){
                    if(nums[n1 - 1] == target){
                        n1--;
                    }else{
                        break;
                    }
                }
                res[0] = n1;
                while(n2 +1 <= len -1){
                    if(nums[n2 + 1] == target){
                        n2++;
                    }else{
                        break;
                    }
                }
                res[1] = n2;
                return res;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}