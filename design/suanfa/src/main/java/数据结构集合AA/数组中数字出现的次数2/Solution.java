package 数据结构集合AA.数组中数字出现的次数2;

class Solution {
    public int singleNumber(int[] nums) {
        int[] c = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                c[j] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
        }
        for (int j = 0; j < 32; j++) {
            c[j] = c[j] % 3;
        }
        int res = 0;
        for (int j = 0; j < 32; j++) {
            res = res << 1;
            res = res | (c[31 - j] % 3);
        }
        return res;
    }
}