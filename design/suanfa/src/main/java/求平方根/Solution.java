package 求平方根;

import 二个栈实现一个队列.Main;

import java.util.*;


public class Solution {
    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }

        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            if (mid * mid == x || ((mid * mid < x) && ((mid + 1) * (mid + 1) > x))) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else if (mid * mid > x) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sqrt(1518991037));
    }
}
