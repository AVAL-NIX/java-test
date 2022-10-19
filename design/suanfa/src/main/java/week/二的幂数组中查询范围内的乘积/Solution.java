package week.二的幂数组中查询范围内的乘积;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int power = 1;
        List<Integer> powers = new ArrayList<>();
        while (n >= power) {
            power = power << 1;
        }
        while (n > 0) {
            power = power >> 1;
            if (n - power >= 0) {
                powers.add(power);
                n = n - power;
            } else {
                break;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
//            long v = (e - s ) == 0 ? powers.get(s) : 1;
            long v = 1;
            for (int j = s; j <= e; j++) {
                Integer integer = powers.get(j);
                v = (v * integer) % 1000000007;
            }
            result[i] = (int) v;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(2 << 1);
//        System.out.println(new Solution().productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}}));
        System.out.println(new Solution().productQueries(2, new int[][]{{0, 0}}));
        System.out.println(new Solution().productQueries(13, new int[][]{{1,2},{1,1}}));
    }
}