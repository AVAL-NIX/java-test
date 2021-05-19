package 查找算法集合AA.分组;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @param k int整型
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve(int n, int k, int[] a) {
        int left = 0, right = getSum(a);
        while (left < right) {
            int mid = left + (int)Math.ceil((right - left) / 2.0);
            if (check(k, a, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    private boolean check(int k, int[] a, int mid) {
        int countK = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum >= mid) {
                sum = 0;
                countK++;
            }
        }

        return countK >= k;
    }
}
