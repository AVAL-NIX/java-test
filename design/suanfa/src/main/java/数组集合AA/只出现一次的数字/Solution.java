package 数组集合AA.只出现一次的数字;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
          val = i ^ val;
        }
        return val;
    }
}