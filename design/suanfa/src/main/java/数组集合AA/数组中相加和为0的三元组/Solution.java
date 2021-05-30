package 数组集合AA.数组中相加和为0的三元组;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
            return arr;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> result = twoSum(num,i +1 , 0 - num[i]);
            if (result.size() > 0) {
                for (ArrayList<Integer> integers : result) {
                    arr.add(new ArrayList<>(Arrays.asList( num[i] ,integers.get(0), integers.get(1))));
                }
            }
            while (i < num.length -1 && num[i] == num[i + 1]) {
                i++;
            }
        }
        return arr;
    }


    public ArrayList<ArrayList<Integer>> twoSum(int[] num,int i , int target) {
        int left = i, right = num.length -1;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        while (left < right) {
            ArrayList<Integer> temp = new ArrayList<>();
            int result = target - (num[left] + num[right]);
            int leftValue = num[left];
            int rightValue = num[right];
            if (result == 0) {
                temp.add(leftValue);
                temp.add(rightValue);
                arr.add(temp);
                while (left < right && leftValue == num[left] ){
                    left++;
                }
                while (left < right && rightValue == num[right]){
                    right--;
                }
            } else if (result < 0) {
                while (left < right && rightValue == num[right]){
                    right--;
                }
            } else if(result > 0) {
                while (left < right && leftValue == num[left] ){
                    left++;
                }
            }
        }
        return arr;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }
}