package 字符串集合AA.左旋转字符串;

class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}