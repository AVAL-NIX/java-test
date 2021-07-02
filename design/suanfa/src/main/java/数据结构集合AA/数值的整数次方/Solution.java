package 数据结构集合AA.数值的整数次方;

public class Solution {
    public double Power(double base, int exponent) {
        if(exponent < 0){
            base = 1/ base;
            exponent = -exponent;
        }
        return q_power(base , exponent);
  }
    
    
    public double q_power(double base, int exponent){
        if(exponent == 0){
            return 1.0;
        }
        double res = q_power(base, exponent / 2);
        if( (exponent & 1) == 1){
            return res * res * base;
        }else{
            return res * res;
        }
        
    }
}