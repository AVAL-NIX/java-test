package 数组集合AA.最长无重复子数组;

import java.util.*;


public class Solution {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                if (hashMap.size() > result) {
                    result = hashMap.size();
                }
                hashMap.clear();
            } else {
                hashMap.put(arr[i], arr[i]);
            }
        }
        if (hashMap.size() > result) {
            result = hashMap.size();
        }

        return result;
    }
}
