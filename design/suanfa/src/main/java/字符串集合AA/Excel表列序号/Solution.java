package 字符串集合AA.Excel表列序号;

class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("ZY"));
    }
}