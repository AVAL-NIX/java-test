package 数组集合AA.汉明距离;

class Solution {
    public int hammingDistance(int x, int y) {
        System.out.println(Integer.toBinaryString(x ^ y));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(  Integer.bitCount(5));

        return 1;
    }


    public static void main(String[] args) {
        new Solution().hammingDistance(1,4);
    }


}