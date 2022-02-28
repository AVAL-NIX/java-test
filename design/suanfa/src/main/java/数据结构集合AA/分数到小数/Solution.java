package 数据结构集合AA.分数到小数;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        long n = (long) numerator;
        long d = (long) denominator;
        // 整数
        if (n % d == 0) {
            return String.valueOf(n / d);
        }

        StringBuilder sb = new StringBuilder();

        //处理-号
        //  《 的优先级 大于 ^
        if (n < 0 ^ d < 0) {
            sb.append("-");
        }

        //
        // 整数部分
        d = Math.abs(d);
        n = Math.abs(n);
        long integerPart = n / d;
        sb.append(integerPart);
        sb.append('.');

        // 判断循环不问

        StringBuilder point = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        long remainder = n % d;
        int index = 0;
        // 是有限小数
        while (remainder != 0 && !map.containsKey(remainder)) {
            map.put(remainder, index);
            remainder *= 10;
            point.append(remainder / d);
            remainder %= d;
            index++;
        }
        if(remainder != 0 ){
            int rIndex = map.get(remainder);
            point.insert(rIndex,"(");
            point.append(")");
        }
        sb.append(point.toString());
        return sb.toString();
    }


}