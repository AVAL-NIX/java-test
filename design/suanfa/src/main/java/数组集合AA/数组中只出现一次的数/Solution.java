package 数组集合AA.数组中只出现一次的数;

import java.util.*;
import java.util.Map.Entry;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int一维数组
     * @param k   int
     * @return int
     */
    public int foundOnceNumber(int[] arr, int k) {
        int res = k;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Entry<Integer, Integer>> entries = map.entrySet();
        for (Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() != k){
                return entry.getKey();
            }
        }
        return res;
    }
}






