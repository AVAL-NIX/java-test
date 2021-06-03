package 动态规划AA.子数组最大乘积;

public class Solution {
    public double maxProduct(double[] arr) {
        dp = new double[arr.length];
        return dp(arr, 0);
    }

    double[] dp;

    public double dp(double[] arr, int i) {
        //base case
        if (i >= arr.length - 1) {
            return 1;
        }

        //to
        double res = Math.max(
                dp(arr, i + 1), dp(arr, i + 1) * arr[i]
        );
        return res;
    }


    public double maxProduct2(double[] arr) {
        int n = arr.length;
        double[] maxDP = new double[arr.length];
        double[] minDP = new double[arr.length];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return arr[0];
        }
        maxDP[0] = arr[0];
        minDP[0] = arr[0];
        double total = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                // 正 * 正 = 正
                maxDP[i] = Math.max(
                        arr[i], maxDP[i - 1] * arr[i]
                );
                // 负 * 正 = 负
                minDP[i] = Math.min(
                        arr[i], minDP[i - 1] * arr[i]
                );
            } else {
                // 负 * 负 = 正
                maxDP[i] = Math.max(
                        arr[i], minDP[i - 1] * arr[i]
                );
                // 负 * 正 = 负
                minDP[i] = Math.min(
                        arr[i], maxDP[i - 1] * arr[i]
                );
            }
            total = Math.max(total, maxDP[i]);

        }
        return total;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new double[]{1, -2.5, 4, 0, 3, 0.5, 8, -1}));
        System.out.println(new Solution().maxProduct2(new double[]{1, -2.5, 4, 0, 3, 0.5, 8, -1}));
    }
}