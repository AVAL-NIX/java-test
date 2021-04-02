package 二分查找;

import java.util.*;


/**
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] nums, int target) {
        // write code here
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 0, end = nums.length;
        while (start <= end) {
            // 找出下标
            int mid = start + ((end - start) >> 1);
            if (target == nums[mid]) {
                //这里有可能不是第1个。
                while(mid > 0 ){
                    if(target == nums[mid-1]){
                        mid--;
                    }else if(target > nums[mid-1]){
                        break;
                    }
                }
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = {1,2,2,4};
        int[] numbers2 = {-2,1,2};
        System.out.println(search(numbers2,-2));
    }
}
