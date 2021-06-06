package 数组集合AA.最富有客户的资产总量;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int[] tempArr = accounts[i];
            int tempMax = 0;
            for (int j = 0; j < tempArr.length; j++) {
                tempMax += tempArr[j];
            }
            max = Math.max(tempMax, max);
        }
        return max;
    }
}