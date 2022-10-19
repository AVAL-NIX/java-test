package week.反转之后不同整数的数目;

import java.util.HashSet;

class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = nums.length, j = 0; i < nums.length * 2; i++, j++) {
            int rev = rev(nums[j]);
            hashSet.add(rev);
        }
        return hashSet.size();
    }

    public int rev(int i) {
        String b = i + "";
        char[] arr = b.toCharArray();
        for (int j = 0; j < b.length() / 2; j++) {
            char t = arr[j];
            arr[j] = arr[b.length() - 1 - j];
            arr[b.length() - 1 - j] = t;
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDistinctIntegers(new int[]{1,13,10,12,31}));
        System.out.println(new Solution().countDistinctIntegers(new int[]{2,2,2}));
    }
}