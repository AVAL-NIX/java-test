package 数据结构集合AA.每日温度;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        /**单调栈模板**/
        for (int i = temperatures.length -1 ; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                //丢弃比当前元素小的值
                deque.pop();
            }
            //得到索引间距
            result[i] = deque.isEmpty() ? 0 : (deque.peek() - i);
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
