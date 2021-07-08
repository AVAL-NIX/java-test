package 数组集合AA.扑克牌中的顺子;

import java.util.Arrays;

class Solution {
    public boolean isStraight(int[] nums) {
        int ex = 0;
        Arrays.sort(nums);
        int pre = -1;
        for (int i = 0; i < nums.length; ) {
            int v = nums[i];
            //统计小王数量
            if (v == 0) {
                ex++;
                i++;
                continue;
            }
            //初始赋值
            if (pre == -1) {
                pre = v;
                i++;
                continue;
            }
            //如果是连续的数则跳过这张牌
            if (pre == v - 1) {
                pre = v;
                i++;
            } else {
                //如果不连续用小王代替 pre+1
                ex--;
                pre = pre + 1;
                if (ex < 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean IsContinuous(int [] numbers) {
        int ex = 0;
        for(int i=0; i< numbers.length ; i++){
            if(numbers[i] == 0){
                ex++;
            }
        }
        Arrays.sort(numbers);
        int pre = -1;
        for(int i= ex; i< numbers.length ; i++){
            if(pre == -1){
                pre = numbers[i];
                continue;
            }
            if(pre+1 == numbers[i]){
                pre = numbers[i];
                continue;
            }else{
                if(ex == 0){
                    return false;
                }else{
                    pre++;
                    ex--;
                }
            }

        }
        return true;

    }
}