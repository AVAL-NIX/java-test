package 数组集合AA.数组中只出现一次的两个数字;

import java.util.*;
import java.util.Map.Entry;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        int[] result = new int[2];
        int index = 0;
        Set<Entry<Integer, Integer>> entries = map.entrySet();
        for (Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() != 2) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}