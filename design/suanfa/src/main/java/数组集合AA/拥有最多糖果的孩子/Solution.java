package 数组集合AA.拥有最多糖果的孩子;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i=0 ; i< candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        List<Boolean> result = new ArrayList<Boolean>();
        for(int i=0 ; i< candies.length; i++){
            result.add(max <= candies[i] + extraCandies);
        }
        return result;
    }
}