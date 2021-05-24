package 动态规划AA.零钱兑换;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BFS

 */
class Solution2 {

    public int coinChange(int[] coins, int amount) {
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(amount);
        int[] table = new int[amount + 1];
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                int temp = deque.pop();
                if (temp == 0) {
                    return count;
                }
                for (int coin : coins) {
                    if (temp >= coin && table[temp - coin] == 0) {
                        deque.add(temp - coin);
                        table[temp - coin] = 1;
                    }
                }
            }
            count += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}
                , 9864));
    }
}
