package 数组集合AA.缺失的第一个正整数;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared(int[] nums) {
        // write code here
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= nums.length && nums[i] > 0) {
                arr[nums[i]] = 1;
            }
        }
        for (int i = 1; i < arr.length; ++i){
            if (arr[i] == 0){
                return i;
            }

        }
        return arr.length;
    }
}