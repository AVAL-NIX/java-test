package 数据结构集合AA.数组中未出现的最小正整数;

import java.util.*;


public class Solution {
    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        int min = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (min == arr[i]) {
                    min = arr[i] + 1;
                } else {
                    return min;
                }
            }
        }
        return min;
    }
}