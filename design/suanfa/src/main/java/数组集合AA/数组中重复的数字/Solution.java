package 数组集合AA.数组中重复的数字;

import java.util.*;


/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3
 * 。存在不合法的输入的话输出-1
 */
public class Solution {

    public int duplicate (int[] numbers) {
        for(int i=0; i < numbers.length; i++){
            if(numbers[i]!=i){
                if(numbers[i] == numbers[numbers[i]]){
                    return numbers[i];
                }
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
                i--;
            }
        }
        return -1;
    }
}