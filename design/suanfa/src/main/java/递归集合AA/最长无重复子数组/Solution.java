package 递归集合AA.最长无重复子数组;

import java.util.*;


public class Solution {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        int left = 0, right = 0, maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (left <= right && right < arr.length) {
            if (map.containsKey(arr[right])) {
                //从left删除至与arr[right]等值元素
                while (arr[left] != arr[right]) {
                    map.remove(arr[left]);
                    ++left;
                }
                left++;
            }
            map.put(arr[right], right);
            maxLength = maxLength < map.size() ? map.size() : maxLength;
            right++;
        }

        return maxLength;
    }
}
