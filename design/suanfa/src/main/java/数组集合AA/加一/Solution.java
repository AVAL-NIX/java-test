package 数组集合AA.加一;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        long res = 0;
        boolean isUp = false;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            //题目+1
            if (i == digits.length - 1) {
                value++;
            }
            //进位++
            if (isUp) {
                value++;
            }
            if (value > 9) {
                value %= 10;
                isUp = true;
            }else{
                isUp = false;
            }
            result.addFirst(value);
        }
        if(isUp){
            result.addFirst(1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1, 2, 3})));
    }
}