package 栈和排序;

import java.util.*;


public class Solution {
    /**
     * 栈排序
     * 2,1,5,3,4
     * [5,4,3,1,2]
     *
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public int[] solve(int[] a) {
        // write code here
        int[] maxs = new int[a.length];
        int max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            max = Math.max(max, a[i]);
            maxs[i] = max;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            while (!stack.isEmpty() && i < a.length - 1 && stack.peek() > maxs[i + 1]) {
                resultArr.add(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            resultArr.add(stack.pop());
        }

        return resultArr.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solve(new int[]{2, 1, 5, 3, 4})));
    }
}
