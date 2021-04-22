package 丑数;

public class Solution {
    /**
     * 暴利解法
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 0) {
            return 0;
        }
        int count = 0;
        int forIndex = 1;
        while (true) {
            if (isUgly(forIndex)) {
                count++;
            }
            if (count == index) {
                return forIndex;
            }
            forIndex++;
        }
    }


    public boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }

        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1 ? true : false;
    }


    /**
     * 动态规划解法
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution2(int index) {
        if (index <= 0) {
            return 0;
        }
        int dp[] = new int[index + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= index; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
        }
        return dp[index];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(10));
    }
}
