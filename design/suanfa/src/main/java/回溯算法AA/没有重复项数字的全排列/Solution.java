package 回溯算法AA.没有重复项数字的全排列;

import java.util.*;

public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        LinkedList track = new LinkedList();
        trackFn(num,track);
        return res;
    }
    
    
    private void trackFn(int[] nums, LinkedList track){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return ;
        }
        
        for(int i =0; i< nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            
            trackFn(nums, track);
            
            track.removeLast();
        }
    }
}