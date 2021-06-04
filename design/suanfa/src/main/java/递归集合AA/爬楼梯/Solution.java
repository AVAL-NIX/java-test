package 递归集合AA.爬楼梯;

import java.util.Arrays;

class Solution {
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n);
    }

    public int fib(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        memo[n - 1] = fib(n - 1);
        memo[n - 2] = fib(n - 2);
        return memo[n - 1] + memo[n - 2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }
}