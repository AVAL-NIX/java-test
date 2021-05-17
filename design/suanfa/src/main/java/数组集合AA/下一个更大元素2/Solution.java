package 数组集合AA.下一个更大元素2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    /**
     * 暴力解法 ， 不推荐。 。
     * 31 ms ....
     *
     * @param args
     */
//    public int[] nextGreaterElements(int[] nums) {
//        int[] result = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            //判定个子高矮
//            int max = nums[i];
//            boolean flag = false;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] > max) {
//                    max = nums[j];
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                for (int j = 0; j < i; j++) {
//                    if (nums[j] > max) {
//                        max = nums[j];
//                        flag = true;
//                        break;
//                    }
//                }
//            }
//            result[i] = !flag ? -1 : max;
//        }
//        return result;
//    }

    /**
     * 139 ms ///
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            //判定个子高矮
            int max = nums[i];
            boolean flag = false;
            for (int j = i ; j < 2 * n - 1; j++) {
                if (nums[j % n] > max) {
                    max = nums[j % n];
                    flag = true;
                    break;
                }
            }
            result[i] = !flag ? -1 : max;
        }
        return result;
    }

    /**
     * 数据结构集合.单调栈
     * 8ms .....
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = n * 2 - 1; i >= 0; i--) {
            //
            while (!deque.isEmpty() && deque.peek() <= nums[i%n]){
                deque.pop();
            }
            result[i%n] = deque.isEmpty()? -1 : deque.peek();
            deque.push(nums[i%n]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 数组集合AA.下一个更大元素2.Solution().nextGreaterElements2(new int[]{
                1, 2, 1})));
    }
}
