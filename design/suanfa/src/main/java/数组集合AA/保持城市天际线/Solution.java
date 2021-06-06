package 数组集合AA.保持城市天际线;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        int colLen = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            int[] temp = grid[i];
            int tempRowMax = 0;
            for (int j = 0; j < temp.length; j++) {
                tempRowMax = Math.max(temp[j], tempRowMax);
            }
            row.add(tempRowMax);
        }


        for (int i = 0; i < colLen; i++) {
            int tempColMax = 0;
            for (int j = 0; j < grid.length; j++) {
                tempColMax = Math.max(grid[j][i], tempColMax);
            }
            col.add(tempColMax);
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] temp = grid[i];
            int max = row.get(i);
            for (int j = 0; j < temp.length; j++) {
                int value = grid[i][j];
                int colMax = col.get(j);
                int minValue = Math.min(colMax,max);
                sum += minValue - value;
            }
        }

        return sum;
    }
}