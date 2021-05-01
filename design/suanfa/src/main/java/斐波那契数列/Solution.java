package 斐波那契数列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] memo = null;

    //

    public int Fibonacci(int n) {
        if (n < 1)
            return 0;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }



//    public int Fibonacci(int n) {
//        if (n < 1)
//            return 0;
//        memo = new int[n + 1];
//        return fib(n);
//    }

    public int fib(int n) {
        if (n == 0) {
            memo[0] = 0;
            return 0;
        }
        if (n == 1) {
            memo[1] = 1;
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println(  new Solution().Fibonacci(4));
    }
}
