package 递归集合AA.跳台阶;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int jumpFloor(int target) {
        return fibonacci(target);
    }

    Map<Integer, Integer> dp = new HashMap<>();

    public int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        dp.put(n , fibonacci(n - 1) + fibonacci(n - 2));
        return dp.get(n);
    }
}
