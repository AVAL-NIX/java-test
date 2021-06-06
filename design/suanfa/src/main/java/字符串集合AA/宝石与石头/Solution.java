package 字符串集合AA.宝石与石头;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] chars = jewels.toCharArray();
        char[] stonesArr = stones.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            for (int j = 0; j < stonesArr.length; j++) {
                if(curr == stonesArr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}