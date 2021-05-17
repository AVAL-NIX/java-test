package 数组集合AA.下一个更大元素1;

import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums1.length - 1; i >= 0; i++) {
            //判定个子高矮
            while(!stack.isEmpty() && stack.peek() <= nums1[i]){
                //矮个子出去 ，因为被前面的高个子[当前的nums[i]  ]挡住了。
                stack.pop();
            }
            result[i] = stack.empty()? -1 : stack.pop();
            //
            stack.push(nums1[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        new Solution().nextGreaterElement(new int[]{1,2,1},null);
    }
}
