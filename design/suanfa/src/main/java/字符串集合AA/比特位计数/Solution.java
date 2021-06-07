package 字符串集合AA.比特位计数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] countBits(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String b = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < b.length(); j++) {
                if ('1' == b.charAt(j)) {
                    count++;
                }
            }
            result.add(count);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}