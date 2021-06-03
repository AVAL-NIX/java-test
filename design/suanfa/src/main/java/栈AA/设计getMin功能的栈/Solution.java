package 栈AA.设计getMin功能的栈;

import java.util.*;

/**
 * 实现一个特殊功能的栈，
 * 在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 */
public class Solution {
    /**
     * return a array which include all ans for op3
     *
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack(int[][] op) {
        MinStack minStack = new MinStack();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            int[] temp = op[i];
            int key = temp[0];
            if (key == 1) {
                int value = temp[1];
                minStack.put(value);
            }
            if (key == 2) {
                int v = minStack.get();
                res.add(v);
            }
            if (key == 3) {
                int v = minStack.getMinValue();
                res.add(v);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public class MinStack {
        Stack<Integer> stack = new Stack();
        Stack<Integer> minStack = new Stack();

        public void put(int v) {
            if (minStack.isEmpty()) {
                minStack.push(v);
            } else {
                if (v <= minStack.peek()) {
                    minStack.push(v);
                }
            }
            stack.push(v);
        }

        public int get() {
            if (stack.isEmpty()) {
                return -1;
            }
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            return stack.pop();
        }

        public int getMinValue() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }
}