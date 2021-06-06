package 数组集合AA.数组异或操作;

class Solution {
    public int xorOperation(int n, int start) {
        int xor = 0;
        for(int i=0 ; i < n ; i++){
            xor = xor ^ (start + 2*i);
        }
        return xor;
    }
}