package 字符串集合AA.哪种连续子字符串更长;

class Solution {
    public boolean checkZeroOnes(String s) {
        if ("1".equals(s)) {
            return true;
        }
        if ("0".equals(s)) {
            return false;
        }
        char[] arr = s.toCharArray();
        int index1 = 0, index0 = 0, temp1 = 0, temp0 = 0;
        char pre = '1';
        for (char c : arr) {
            if (c == '1') {
                temp1++;
                temp0 = 0;
            } else if (c == '0') {
                temp0++;
                temp1 = 0;
            }
            index1 = Math.max(temp1, index1);
            index0 = Math.max(temp0, index0);
        }
        return index1 > index0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkZeroOnes("111000"));
    }
}