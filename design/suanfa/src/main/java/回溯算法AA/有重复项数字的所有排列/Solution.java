package 回溯算法AA.有重复项数字的所有排列;

import java.util.*;

public class Solution {

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] visted = new boolean[num.length];
        trackFn(num, 0, temp,visted);

        return res;

    }

    private void trackFn(int[] num, int i, ArrayList<Integer> temp, boolean[] visted) {
        if (num.length == temp.size()) {
            if(res.contains(temp)){
                return ;
            }
            res.add(new ArrayList<>(temp));
            return ;
        }

        for (int j = 0; j < num.length; j++) {
            if(visted[j]){
                continue;
            }
            visted[j] = true;
            temp.add(num[j]);

            trackFn(num, j, temp, visted);

            visted[j] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1,1,2}));
    }
}