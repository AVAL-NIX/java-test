package 数据结构集合AA.不用加减乘除做加法;

class Solution {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        //  1 1 0 0  a 
        //  1 0 1 0  b 
        //1 0 1 1 0  a + b = n + c
        //  0 1 1 0  a ^ b = n
        //  1 0 0 0  a & b 
        //1 0 0 0 0  (a & b) << 1 = c  /// 这个C, 作为B 与A在& 的时候会归0 ， 所以上面等于0 
        return add(a ^ b, (a & b) << 1);
    }
}