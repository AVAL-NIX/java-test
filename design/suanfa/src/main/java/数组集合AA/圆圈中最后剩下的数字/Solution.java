package 数组集合AA.圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int index = 0;
        while (arr.size() != 1) {
            int len = arr.size();
            index = ((m + index - 1) % len);
            arr.remove(index);
        }
        return arr.get(0);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(5 , 3));
    }
}