package 回溯算法AA.找出所有子集的异或总和再求和;

import java.util.LinkedList;

class Solution {
    //回溯
    public int subsetXORSum(int[] nums) {

        LinkedList<Integer> temp = new LinkedList();
        dfs(nums, 0, temp);
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            LinkedList<Integer> a = res.get(i);
            if (a.size() == 1) {
                sum += a.get(0);
            } else if (a.size() > 1) {
                int xor = 0;
                for (Integer integer : a) {
                    xor = integer ^ xor;
                }
                sum += xor;
            }
        }
        return sum;
    }

    LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    /**
     * 求子集
     * @param nums
     * @param start
     * @param temp
     */
    private void dfs(int[] nums, int start, LinkedList<Integer> temp) {
        //base case
        res.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i++) {

            temp.add(nums[i]);

            dfs(nums, i + 1, temp);

            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetXORSum(new int[]{5, 1, 6}));
    }
}